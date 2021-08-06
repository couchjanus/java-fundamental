# Обобщения (Generics)
 
Обобщения или generics (обобщенные типы и методы) позволяют уйти от жесткого определения используемых типов.

определяем класс для представления банковского счета:
```java

class Account{
     
    private int id;
    private int sum;
     
    Account(int id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public int getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
Класс Account имеет два поля: 
- id - уникальный идентификатор счета 
- sum - сумма на счете.

идентификатор id задан как целочисленное значение (1, 2, 3, 4 и т.д.). 
Однако также нередко для идентификатора используются и строковые значения. 
на момент написания класса мы можем точно не знать, что лучше выбрать для хранения идентификатора - строки или числа. 

мы можем решить данную проблему следующим образом: 
задать id как поле типа Object, который является универсальным и базовым суперклассом для всех остальных типов:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Account acc1 = new Account(2334, 5000); // id - число
        int acc1Id = (int)acc1.getId();
        System.out.println(acc1Id);
         
        Account acc2 = new Account("sid5523", 5000);    // id - строка
        System.out.println(acc2.getId());
    }
}
class Account{
     
    private Object id;
    private int sum;
     
    Account(Object id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public Object getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
мы сталкиваемся с проблемой безопасности типов. 
Например, в следующем случае мы получим ошибку:
```java

Account acc1 = new Account("2345", 5000);
int acc1Id = (int)acc1.getId(); // java.lang.ClassCastException
System.out.println(acc1Id);

```
в процессе разработки мы можем не знать, какой именно тип представляет значение в id, и при попытке получить число в данном случае мы столкнемся с исключением java.lang.ClassCastException.

Писать для каждого отдельного типа свою версию класса Account тоже не является хорошим решением, так как в этом случае мы вынуждены повторяться.

## Обобщения
Обобщения или generics позволяют не указывать конкретный тип, который будет использоваться. 

```java

// определим класс Account как обобщенный:

class Account<T>{
     
    private T id;
    private int sum;
     
    Account(T id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public T getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
## универсальный параметр

С помощью буквы T в определении класса class Account<T> мы указываем, что данный тип T будет использоваться этим классом. 
Параметр T в угловых скобках называется универсальным параметром, так как вместо него можно подставить любой тип. При этом пока мы не знаем, какой именно это будет тип: String, int или какой-то другой. Причем буква T выбрана условно, это может и любая другая буква или набор символов.

После объявления класса мы можем применить универсальный параметр T: 

Метод getId() возвращает значение переменной id, но так как данная переменная представляет тип T, то данный метод также возвращает объект типа T: public T getId().

```java

public class Program{
      
    public static void main(String[] args) {
          
        Account<String> acc1 = new Account<String>("2345", 5000);
        String acc1Id = acc1.getId();
        System.out.println(acc1Id);
         
        Account<Integer> acc2 = new Account<Integer>(2345, 5000);
        Integer acc2Id = acc2.getId();
        System.out.println(acc2Id);
    }
}
class Account<T>{
     
    private T id;
    private int sum;
     
    Account(T id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public T getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
При определении переменной даннного класса и создании объекта после имени класса в угловых скобках нужно указать, какой именно тип будет использоваться вместо универсального параметра. При этом надо учитывать, что они работают только с объектами, но не работают с примитивными типами. То есть мы можем написать Account<Integer>, но не можем использовать тип int или double, например, Account<int>. Вместо примитивных типов надо использовать классы-обертки: 
    - Integer вместо int, 
    - Double вместо double и т.д.

Например, первый объект будет использовать тип String, то есть вместо T будет подставляться String:
```java

Account<String> acc1 = new Account<String>("2345", 5000);

```
В этом случае в качестве первого параметра в конструктор передается строка.

А второй объект использует тип int (Integer):
```java

Account<Integer> acc2 = new Account<Integer>(2345, 5000);

```
## Обобщенные интерфейсы
Интерфейсы, как и классы, также могут быть обобщенными. 
Создадим обобщенный интерфейс Accountable и используем его в программе:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Accountable<String> acc1 = new Account("1235rwr", 5000);
        Account acc2 = new Account("2373", 4300);
        System.out.println(acc1.getId());
        System.out.println(acc2.getId());
    }
}
interface Accountable<T>{
    T getId();
    int getSum();
    void setSum(int sum);
}
class Account implements Accountable<String>{
     
    private String id;
    private int sum;
     
    Account(String id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public String getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
При реализации подобного интерфейса есть две стратегии. 

1. Первая стратегия, когда при реализации для универсального параметра интерфейса задается конкретный тип, например, тип String. Тогда класс, реализующий интерфейс, жестко привязан к этому типу.

2. Вторая стратегия представляет определение обобщенного класса, который также использует тот же универсальный параметр:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Account<String> acc1 = new Account<String>("1235rwr", 5000);
        Account<String> acc2 = new Account<String>("2373", 4300);
        System.out.println(acc1.getId());
        System.out.println(acc2.getId());
    }
}
interface Accountable<T>{
    T getId();
    int getSum();
    void setSum(int sum);
}
class Account<T> implements Accountable<T>{
     
    private T id;
    private int sum;
     
    Account(T id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public T getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
## Обобщенные методы
Кроме обобщенных типов можно также создавать обобщенные методы, которые будут использовать универсальные параметры:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Printer printer = new Printer();
        String[] people = {"Tom", "Alice", "Sam", "Kate", "Bob", "Helen"};
        Integer[] numbers = {23, 4, 5, 2, 13, 456, 4};
        printer.<String>print(people);
        printer.<Integer>print(numbers);
    }
}
 
class Printer{
     
    public <T> void print(T[] items){
        for(T item: items){
            System.out.println(item);
        }
    }
}

```
Особенностью обобщенного метода является использование универсального параметра в объявлении метода после всех модификаторов и перед типом возвращаемого значения.
```java
public <T> void print(T[] items)
```
Затем внутри метода все значения типа T будут представлять данный универсальный параметр.

При вызове подобного метода перед его именем в угловых скобках указывается, какой тип будет передаваться на место универсального параметра:
```java
printer.<String>print(people);
printer.<Integer>print(numbers);

```

## Использование нескольких универсальных параметров
Мы можем также задать сразу несколько универсальных параметров:

```java

public class Program{
      
    public static void main(String[] args) {
          
        Account<String, Double> acc1 = new Account<String, Double>("354", 5000.87);
        String id = acc1.getId();
        Double sum = acc1.getSum();
        System.out.printf("Id: %s  Sum: %f \n", id, sum);
    }
}
class Account<T, S>{
     
    private T id;
    private S sum;
     
    Account(T id, S sum){
        this.id = id;
        this.sum = sum;
    }
     
    public T getId() { return id; }
    public S getSum() { return sum; }
    public void setSum(S sum) { this.sum = sum; }
}

```
В данном случае тип String будет передаваться на место параметра T, а тип Double - на место параметра S.

## Обобщенные конструкторы
Конструкторы как и методы также могут быть обобщенными. В этом случае перед конструктором также указываются в угловых скобках универсальные параметры:
```java


public class Program{
      
    public static void main(String[] args) {
          
        Account acc1 = new Account("cid2373", 5000);
        Account acc2 = new Account(53757, 4000);
        System.out.println(acc1.getId());
        System.out.println(acc2.getId());
    }
}
 
class Account{
     
    private String id;
    private int sum;
     
    <T>Account(T id, int sum){
        this.id = id.toString();
        this.sum = sum;
    }
     
    public String getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
В данном случае конструктор принимает параметр id, который представляет тип T. В конструкторе его значение превращается в строку и сохраняется в локальную переменную.


## Ограничения обобщений
   
Когда мы указываем универсальный параметр у обобщений, то по умолчанию он может представлять любой тип. Однако иногда необходимо, чтобы параметр соответствовал только некоторому ограниченному набору типов. В этом случае применяются ограничения, которые позволяют указать базовый класс, которому должен соответствовать параметр.

Для установки ограничения после универсального параметра ставится слово extends, после которого указывается базовый класс ограничения:
```java

class Account{ }
class Transaction<T extends Account>{ }

```
в данном случае для параметра T в Transaction ограничением является класс Account. То есть на место параметра T мы можем передать либо класс Account, либо один из его классов-наследников.

класс Transaction, который представляет операцию перевода средств между двумя счетами, типизирован параметром T, у которого в качестве ограничения установлен класс Account.:

```java

public class Program{
      
    public static void main(String[] args) {
          
        Account acc1 = new Account("1876", 4500);
        Account acc2 = new Account("3476", 1500);
              
        Transaction<Account> tran1 = new Transaction<Account>(acc1,acc2, 4000);
        tran1.execute();
        tran1 = new Transaction<Account>(acc1,acc2, 4000);
        tran1.execute();
    }
}
class Transaction<T extends Account>{
     
    private T from;     // с какого счета перевод
    private T to;       // на какой счет перевод
    private int sum;    // сумма перевода
     
    Transaction(T from, T to, int sum){
        this.from = from;
        this.to = to;
        this.sum = sum;
    }
    public void execute(){
         
        if (from.getSum() > sum)
        {
            from.setSum(from.getSum() - sum);
            to.setSum(to.getSum() + sum);
            System.out.printf("Account %s: %d \nAccount %s: %d \n", 
                from.getId(), from.getSum(),to.getId(), to.getSum());
        }
        else{
            System.out.printf("Operation is invalid");
        }
    }
}
class Account{
     
    private String id;
    private int sum;
     
    Account(String id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public String getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
При создании объекта Transaction в его конструктор передаются два объекта Account - два счета, между которыми надо осуществить перевод, и сумма перевода.

поскольку мы установили подобное ограничение, то компилятор будет распознавать объекты типа T как объекты типа Account. 
в этом случае мы можем вызывать у объектов типа T методы класса Account. И мы бы не смогли бы это сделать, если бы мы не задали подобного ограничения:
```java

class Transaction<T>{
    // остальное содержимое
}

```
В этом случае была бы ошибка.

## Обобщенные типы в качестве ограничений
В качестве ограничений могут выступать и другие обобщения, которые сами могут иметь ограничения:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Account<String> acc1 = new Account<String>("1876", 4500);
        Account<String> acc2 = new Account<String>("3476", 1500);
              
        Transaction<Account<String>> tran1 = new Transaction<Account<String>>(acc1,acc2, 4000);
        tran1.execute();
        tran1 = new Transaction<Account<String>>(acc1,acc2, 4000);
        tran1.execute();
    }
}
class Transaction<T extends Account<String>>{
     
    private T from;     // с какого счета перевод
    private T to;       // на какой счет перевод
    private int sum;    // сумма перевода
     
    Transaction(T from, T to, int sum){
        this.from = from;
        this.to = to;
        this.sum = sum;
    }
    public void execute(){
         
        if (from.getSum() > sum)
        {
            from.setSum(from.getSum() - sum);
            to.setSum(to.getSum() + sum);
            System.out.printf("Account %s: %d \nAccount %s: %d \n", 
                from.getId(), from.getSum(),to.getId(), to.getSum());
        }
        else{
            System.out.printf("Operation is invalid");
        }
    }
}
class Account<T>{
     
    private T id;
    private int sum;
     
    Account(T id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public T getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

```
В данном случае ограничением для Transaction является тип Account, который типизирован типом String.

## Интерфейсы в качестве оганичений
В качестве ограничений могут выступать также интерфейсы. В этом случае передаваемый на место универсального параметра тип должен реализовать данный интерфейс:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Account acc1 = new Account("1235rwr", 5000);
        Account acc2 = new Account("2373", 4300);
        Transaction<Account> tran1 = new Transaction<Account>(acc1, acc2, 1560);
        tran1.execute();
    }
}
interface Accountable{
    String getId();
    int getSum();
    void setSum(int sum);
}
class Account implements Accountable{
     
    private String id;
    private int sum;
     
    Account(String id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public String getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}
class Transaction<T extends Accountable>{
     
    private T from;     // с какого счета перевод
    private T to;       // на какой счет перевод
    private int sum;    // сумма перевода
     
    Transaction(T from, T to, int sum){
        this.from = from;
        this.to = to;
        this.sum = sum;
    }
    public void execute(){
         
        if (from.getSum() > sum)
        {
            from.setSum(from.getSum() - sum);
            to.setSum(to.getSum() + sum);
            System.out.printf("Account %s: %d \nAccount %s: %d \n", 
                from.getId(), from.getSum(),to.getId(), to.getSum());
        }
        else{
            System.out.printf("Operation is invalid");
        }
    }
}

```
## Множественные ограничения
Также можно установить сразу несколько ограничений. Например, пусть класс Transaction может работать только с объектами, которые одновременно реализуют интерфейс Accountable и являются наследниками класса Person:
```java

class Person{}
interface Accountable{}
 
class Transaction<T extends Person & Accountable>{}

```
## Наследование и обобщения
 
Обобщенные классы могут участвовать в иерархии наследования: могут наследоваться от других, либо выполнять роль базовых классов. Рассмотрим различные ситуации.

## Базовый обобщенный класс
При наследовании от обобщенного класса класс-наследник должен передавать данные о типе в конструкции базового класса:
```java

class Account<T>
{
    private T _id;
    T getId(){return _id;}
    Account(T id)
    {
        _id = id;
    }
}
 
class DepositAccount<T> extends Account<T>{
 
    DepositAccount(T id){
        super(id);
    }
}

```
В конструкторе DepositAccount идет обращение к конструктору базового класса, в который передаются данные о типе.

### Варианты использования классов:
```java

DepositAccount dAccount1 = new DepositAccount(20);
System.out.println(dAccount1.getId());
         
DepositAccount dAccount2 = new DepositAccount("12345");
System.out.println(dAccount2.getId());

// При этом класс-наследник может добавлять и использовать какие-то свои параметры типов:


class Account<T>
{
    private T _id;
    T getId(){return _id;}
    Account(T id)
    {
        _id = id;
    }
}
 
class DepositAccount<T, S> extends Account<T>{
 
    private S _name;
    S getName(){return _name;}
    DepositAccount(T id, S name){
        super(id);
        this._name=name;
    }
}
// Варианты использования:

DepositAccount<Integer, String> dAccount1 = new DepositAccount(20, "Tom");
System.out.println(dAccount1.getId() + " : " + dAccount1.getName());
         
DepositAccount<String, Integer> dAccount2 = new DepositAccount("12345", 23456);
System.out.println(dAccount2.getId() + " : " + dAccount2.getName());

// И еще одна ситуация - класс-наследник вообще может не быть обобщенным:

class Account<T>
{
    private T _id;
    T getId(){return _id;}
    Account(T id)
    {
        _id = id;
    }
}
 
class DepositAccount extends Account<Integer>{
 
    DepositAccount(){
        super(5);
    }
}
// Здесь при наследовании явным образом указывается тип, который будет использоваться конструкциями базового класса, то есть тип Integer. Затем в конструктор базового класса передается значение именно этого типа - в данном случае число 5.

// Вариант использования:

DepositAccount dAccount1 = new DepositAccount();
System.out.println(dAccount1.getId());

```
## Обобщенный класс-наследник


Также может быть ситуация, когда базовый класс является обычным необобщенным классом. Например:

```java

class Account
{
    private String _name;
    String getName(){return _name;}
    Account(String name)
    {
        _name=name;
    }
}
 
class DepositAccount<T> extends Account{
 
    private T _id;
    T getId(){return _id;}
    DepositAccount(String name, T id){
        super(name);
        _id = id;
    }
}
// В этом случае использование конструкций базового класса в наследнике происходит как обычно.

```

## Преобразование обобщенных типов
Объект одного обобщенного типа можно привести к другому типу, если они используют один и тот же тип. Рассмотрим преобразование типов на примере следующих двух обобщенных классов:

```java

class Account<T>
{
    private T _id;
    T getId(){return _id;}
    Account(T id)
    {
        _id = id;
    }
}
 
class DepositAccount<T> extends Account<T>{
 
    DepositAccount(T id){
        super(id);
    }
}

```
Мы можем привести объект DepositAccount<Integer> к Account<Integer> или DepositAccount<String> к Account<String>:
```java

DepositAccount<Integer> depAccount = new DepositAccount(10);
Account<Integer> account = (Account<Integer>)depAccount;
System.out.println(account.getId());

// Но сделать то же самое с разнотипными объектами мы не можем. 
// Например, следующий код не будет работать:

DepositAccount<Integer> depAccount = new DepositAccount(10);
Account<String> account = (Account<String>)depAccount;

```

