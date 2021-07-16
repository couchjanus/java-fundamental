# Интерфейсы

Механизм наследования очень удобен, но он имеет свои ограничения. В частности мы можем наследовать только от одного класса, в отличие, например, от языка С++, где имеется множественное наследование.

В языке Java подобную проблему частично позволяют решить интерфейсы. Интерфейсы определяют некоторый функционал, не имеющий конкретной реализации, который затем реализуют классы, применяющие эти интерфейсы. И один класс может применить множество интерфейсов.

## Интерфейс — это ссылочный тип в Java. 
Интерфейс это конструкция языка, в рамках которой принято описывать абстрактные публичные (abstract public) методы и статические константы (final static). Интерфейсы Java созданы для поддержки динамического выбора (resolution) методов во время выполнения программы.
Интерфейс схож с классом, но в отличие от последних у интерфейсов нет переменных представителей, а в объявлениях методов отсутствует реализация. Класс реализует интерфейс, таким образом наследуя абстрактные методы интерфейса.

### Интерфейс схож с классом следующим образом:
- Интерфейс может содержать любое количество методов.
- Интерфейс записан в файле с расширением .java, и имя интерфейса совпадает с именем файла.
- Байт-код интерфейса находится в .class файле.
- Интерфейсы появляются в пакетах, и их соответствующий файл байт-кода должен быть в структуре каталогов, которая совпадает с именем пакета.

### Отличие интерфейса от класса в Java:
- Вы не можете создать экземпляр интерфейса.
- В интерфейсе не содержатся конструкторы.
- Все методы в интерфейсе абстрактные.
- Интерфейс не может содержать поля экземпляров. Поля, которые могут появиться в интерфейсе, обязаны быть объявлены и статическими, и final.
- Интерфейс не расширяется классом, он реализуется классом.
- Интерфейс может расширить множество интерфейсов.

## У интерфейса могут быть следующие модификаторы.
• public (если он есть, то интерфейс доступен отовсюду, если его нет — доступен только в данном пакете).
• abstract (так как интерфейс всегда абстрактный, то модификатор обычно опускается).
• strictfp— все позже реализуемые методы должны будут работать с числами с плавающей точкой аналогично на всех машинах Java.


## Объявление интерфейсов

Ключевое слово interface используется для объявления интерфейса:
```java

/* File name : NameOfInterface.java */

// Любое количество запросов импорта

public interface NameOfInterface { //создание интерфейса
   // Любое количество полей final и static
   // Любое количество объявлений абстрактных методов
}

```

## Создание иерархий классов

```java
public abstract class Employee
{
    private int id;
    private String name;
    private String company;
    
    public Employee() {
    }
        
    public Employee(int id, String name, String company ) {
        this.name=name;
        this.id = id;
        this.company = company;
    }
    
    public String getCompany() {
          return company;
    }
    
    public String getName() { 
        return name; 
    }

    public int getId() { 
        return id; 
    }
    
    //  каждый экземпляп Employee должен иметь метод .calculate_payroll(), 
    // который возвращает еженедельную зарплату сотруднику. 
    //  Реализация этого интерфейса отличается в зависимости от типа Employee.
    
    public double calculate_payroll() {
        return 3.14;
    }
    
}


/**
 * производный класс SalaryEmployee, который наследует Person. 
 * Класс инициализируется с помощью id и name,
 *  
 */

public class SalaryEmployee extends Employee {

    double weekly_salary;
    
    public SalaryEmployee(int id, String name, String company, double weekly_salary) {
        super(id, name, company);
        this.weekly_salary = weekly_salary;
        
    }

    /**
     * административные работники имеют фиксированную зарплату, 
     * поэтому каждую неделю им платят одну и ту же сумму
     */
    
    public double calculate_payroll() {
        return this.weekly_salary;
    }

}

/**
 * 
 * В компании также работают рабочие, которые получают почасовую оплату, 
 * поэтому мы добавим HourlyEmployee в систему управления персоналом:
 *
 */
public class HourlyEmployee extends Employee {

    int hours_worked;
    double hour_rate;
    
    public HourlyEmployee(int id, String name, String company,  int hours_worked, double hour_rate) {
        super(id, name, company);
        this.hour_rate = hour_rate;
        this.hours_worked = hours_worked;
    }
    
    public double calculate_payroll() {
        return this.hour_rate * hours_worked;
    }
}

public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        HourlyEmployee bob = new HourlyEmployee(1, "Bob", "Goolee", 20, 77.88);
        
        System.out.printf("Payroll for: %d \t %s \t %s\n", bob.getId(), bob.getName(), bob.getCompany());
        System.out.printf("Employee  amount:\t %s \n", bob.calculate_payroll());
        SalaryEmployee mary = new SalaryEmployee(2, "Mary", "Doolee", 444.99);
        System.out.printf("Payroll for: %d \t %s \t %s\n", mary.getId(), mary.getName(), mary.getCompany());
        System.out.printf("Employee  amount:\t %s \n", mary.calculate_payroll());
        
    }
}

```

### Интерфейс Printable:
Написание интерфейса схоже с написанием класса. Но класс описывает атрибуты и поведения объекта. И интерфейс содержит поведения, которые класс реализует.

```java

public interface IEmployee {
    
    public double calculate_payroll();

}

```
Интерфейс может определять константы и методы, которые могут иметь, а могут и не иметь реализации. Методы без реализации похожи на абстрактные методы абстрактных классов. Так, в данном случае объявлен один метод, который не имеет реализации.

## Интерфейсы имеют следующие свойства:
- Интерфейс абстрактный косвенно. Вам не нужно использовать ключевое слово abstract во время объявления интерфейса.
- Каждый метод в интерфейсе косвенно абстрактным. Объявляемые методы не содержат тел, их объявления завершаются точкой с запятой.
- Методы в интерфейсе косвенно публичны. Все методы интерфейса не имеют модификаторов доступа и являются public abstract. Модификаторы необязательны, так как цель интерфейса - определение функционала для реализации его классом. Поэтому весь функционал должен быть открыт для реализации.


### При переопределении методов в интерфейсе, нужно следовать некоторым правилам:
- Проверенные исключения не должны быть объявлены по методам реализации, отличным от тех, которые были объявлены методом интерфейса или подклассами тех, которые были объявлены методом интерфейса.
- Подпись метода интерфейса и того же типа или подтипа возврата должна поддерживаться (сохраняться) при переопределении методов.
- Сам класс реализации может быть абстрактным, а если это так, то методы интерфейса не должны быть реализованы.

## Реализация интерфейса
Когда класс реализует интерфейс, вы можете представить себе, что класс словно подписывает контракт с интерфейсом, соглашаясь совершить конкретные его поведения. Если класс не исполняет все поведения интерфейса, то класс должен объявить себя абстрактным. Если класс, реализующий интерфейс, не является абстрактным, все методы интерфейса должны быть определены в классе.

Ключевое слово implements появляется при объявлении класса в его расширенной части.

```java

public class SalaryEmployee extends Employee implements IEmployee {

    double weekly_salary;
    
    public SalaryEmployee(int id, String name, String company, double weekly_salary) {
        super(id, name, company);
        this.weekly_salary = weekly_salary;
        
    }

    /**
     * административные работники имеют фиксированную зарплату, 
     * поэтому каждую неделю им платят одну и ту же сумму
     */
    
    public double calculate_payroll() {
        return this.weekly_salary;
    }

}

```

## Класс реализующий интерфейс

Класс реализующий интерфейс должен содержать полный набор методов, определенных в этом интерфейсе. Но в каждом классе могут быть определены и свои методы. 

```java
public class SalaryEmployee extends Employee implements IEmployee {

    double weekly_salary;
    
    public SalaryEmployee(int id, String name, String company, double weekly_salary) {
        super(id, name, company);
        this.weekly_salary = weekly_salary;
        
    }

    /**
     * административные работники имеют фиксированную зарплату, 
     * поэтому каждую неделю им платят одну и ту же сумму
     */
    
    public double calculate_payroll() {
        return this.weekly_salary;
    }
    
    public void display(){
      System.out.printf("Employee Name: %s \t Id: %d \n", super.getName(), getId());
    }

}

```

В тоже время мы не можем напрямую создавать объекты интерфейсов, поэтому следующий код не будет работать:
```java

IEmployee iemp = new IEmployee();
iemp.print();

```
Одним из преимуществ использования интерфейсов является то, что они позволяют добавить в приложение гибкости. Например, в дополнение к классу SalaryEmployee определим еще один класс, который будет реализовывать интерфейс IEmployee:
```java
/**
 * 
 * В компании также работают рабочие, которые получают почасовую оплату, 
 * поэтому мы добавим HourlyEmployee в систему управления персоналом:

 * @author janus
 *
 */
public class HourlyEmployee extends Employee implements IEmployee {

    int hours_worked;
    double hour_rate;

    // String company;
    
    public HourlyEmployee(int id, String name, String company,  int hours_worked, double hour_rate) {
        super(id, name, company);
        this.hour_rate = hour_rate;
        this.hours_worked = hours_worked;
    }
    
    public double calculate_payroll() {
        return this.hour_rate * hours_worked;
    }
}

```

## Множественная реализация интерфейсов

Если нам надо применить в классе несколько интерфейсов, то они все перечисляются через запятую после слова implements:
```java

public class HourlyEmployee extends Employee implements IEmployee, Employee.NestedIf 
{
}

```

## Наследование интерфейсов
Интерфейс может расширять другой интерфейс так же, как класс другой класс. 

Если класс реализует интерфейс, но не полностью реализует определенные в нем методы, он должен быть объявлен как abstract. Один класс может реализовать любое количество интерфейсов.
Ключевое слово extends используется для расширения интерфейса, и дочерний интерфейс наследует методы родительского интерфейса.
```java

public interface ICompany {
    public String getCompany();
    public String getName();
    public int getId()
}
// Интерфейсы, как и классы, могут наследоваться:

public interface IEmployee extends ICompany {
    
    public double calculate_payroll();

}

```
Класс HourlyEmployee и класс SalaryEmployee связаны тем, что они реализуют интерфейс IEmployee. Поэтому мы динамически в программе можем создавать объекты IEmployee как экземпляры обоих классов:

```java

    public static void main(String[] args) {
        
        IEmployee bob = new HourlyEmployee(1, "Bob", "Goolee", 20, 77.88);
        System.out.printf("Payroll for: %d \t %s \t %s\n", bob.getId(), bob.getName(), bob.getCompany());
        System.out.printf("Employee  amount:\t %s \n", bob.calculate_payroll());
        
        IEmployee mary = new SalaryEmployee(2, "Mary", "Doolee", 444.99);
        System.out.printf("Payroll for: %d \t %s \t %s\n", mary.getId(), mary.getName(), mary.getCompany());
        System.out.printf("Employee  amount:\t %s \n", mary.calculate_payroll());
        
    }

```

## Класс может иметь любое количество интерфейсов. 
Все, что нужно сделать — это реализовать в классе полный набор методов всех интерфейсов. Сигнатуры таких методов класса должны точно совпадать с сигнатурами методов реализуемого в этом классе интерфейса. 

Интерфейсы обладают своей собственной иерархией, не пересекающейся с классовой иерархией наследования. Это дает возможность реализовать один и тот же интерфейс в различных классах, никак не связанных по линии иерархии классового наследования. Именно в этом и проявляется главная сила интерфейсов.

С помощью интерфейса можно указать, что именно должен выполнять класс его реализующий, но не как это делать. Способ реализации выбирает сам класс. Интерфейсы не способны сохранять данные состояния. Интерфейсы - это один из механизмов реализации принципа полиморфизма "один интерфейс, несколько методов". 


## Методы по умолчанию в интерфейсах

Методы по умолчанию в интерфейсах - это методы, у которых есть реализация. Другое их название - методы расширения. Классы, реализующие интерфейсы, не обязаны переопределять такие методы, но могут если это необходимо. 

Метод по умолчанию - это обычный метод без модификаторов, который помечается ключевым словом default. Затем в классе нам необязательно этот метод реализовать, хотя мы можем его и переопределить

Интерфейс ICompany объявляет метод по умолчанию defaultMethod() с базовой реализацией:

```java

public interface ICompany {
    public String getCompany();
    public String getName();
    public int getId();
    
    default String defaultMethod() {
        return "Объект типа String по умолчанию";
    }
}

```

Класс HourlyEmployee, реализующий этот интерфейс, не переопределяет метод defaultMethod(). 

А если класс SalaryEmployee не устраивает реализация по умолчанию, он переопределяет этот метод: 
```java

public class SalaryEmployee extends Employee implements IEmployee {

    double weekly_salary;
    
    public SalaryEmployee(int id, String name, String company, double weekly_salary) {
        super(id, name, company);
        this.weekly_salary = weekly_salary;
        
    }

    /**
     * административные работники имеют фиксированную зарплату, 
     * поэтому каждую неделю им платят одну и ту же сумму
     */
    
    public double calculate_payroll() {
        return this.weekly_salary;
    }
    
    public void display(){
      System.out.printf("Employee Name: %s \t Id: %d \n", super.getName(), getId());
    }
    
    @Override
    public String defaultMethod() {
        return "Другая символьная строка";
    }

}

public class SomeInterfaceImpl2 implements SomeInterface {
    @Override
    public String defaultMethod() {
        return "Другая символьная строка";
    }
}


```
Для объекта класса HourlyEmployee вызовется метод, реализованный в интерфейсе, а для объекта класса SalaryEmployee - его собственная реализация:
```java

public static void main(String[] args) {
       
        IEmployee bob = new HourlyEmployee(1, "Bob", "Goolee", 20, 77.88);
        System.out.printf("Payroll for: %d \t %s \t %s\n", bob.getId(), bob.getName(), bob.getCompany());
        System.out.printf("Employee  amount:\t %s \n", bob.calculate_payroll());
        System.out.println(bob.defaultMethod());
        
        IEmployee mary = new SalaryEmployee(2, "Mary", "Doolee", 444.99);
        System.out.printf("Payroll for: %d \t %s \t %s\n", mary.getId(), mary.getName(), mary.getCompany());
        System.out.printf("Employee  amount:\t %s \n", mary.calculate_payroll());
        System.out.println(mary.defaultMethod());
        
    }


```
## Статические методы интерфейса
Статические методы интерфейса, как и класса, можно вызывать независимо от любого объекта. Для вызова статического метода достаточно указать имя интерфейса и через точку имя самого метода.
```java

public interface IEmployee extends ICompany {
    
    public double calculate_payroll();
    
    static String staticMethod() {
        return "I'm statis method";
    }

}

System.out.println(IEmployee.staticMethod());


```

## Приватные методы
По умолчанию все методы в интерфейсе имеют модификатор public. Однако начиная с Java 9 мы также можем определять в интерфейсе методы с модификатором private. Они могут быть статическими и нестатическими, но они не могут иметь реализации по умолчанию.

Подобные методы могут использоваться только внутри самого интерфейса, в котором они определены. То есть к примеру нам надо выполнять в интерфейсе некоторые повторяющиеся действия, и в этом случае такие действия можно выделить в приватные методы:


```java

    public static void main(String[] args) {
          
        IEmployee bob = new HourlyEmployee(1, "Bob", "Goolee", 20, 77.88);
        System.out.printf("Payroll for: %d \t %s \t %s\n", bob.getId(), bob.getName(), bob.getCompany());
        System.out.printf("Employee  amount:\t %s \n", bob.calculate_payroll());
        System.out.println(bob.defaultMethod());
        
        System.out.println(IEmployee.staticMethod());
        
        
        System.out.println(bob.sum(1, 2));
        System.out.println(bob.sum(1, 2, 4));
    }


public interface IEmployee extends ICompany {
    
    public double calculate_payroll();
    
    public static String staticMethod() {
        return "I'm statis method";
    }
    
    default int sum(int a, int b){
        return sumAll(a, b);
    }
    default int sum(int a, int b, int c){
        return sumAll(a, b, c);
    }
     
    private int sumAll(int... values){
         int result = 0;
         for(int n : values){
             result += n;
         }
         return result;
    }

}


```

## Внутренние интерфейсы

Интерфейсы объявленные в классах или в других интерфейсах называются внутренние или вложенные. Например, интерфейс NestedIf определен внутри класса Employee:
```java

public abstract class Employee implements ICompany
{
    private int id;
    private String name;
    private String company;
    
    public Employee() {
    }
        
    public Employee(int id, String name, String company ) {
        this.name=name;
        this.id = id;
        this.company = company;
    }
    
    public interface NestedIf {
        boolean isNotNegative(int x);
    }
}

```
При обращении к интерфейсу NestedIf требуется указывать имя его внешнего класса - Employee.NestedIf:
```java

public class HourlyEmployee extends Employee implements IEmployee, Employee.NestedIf {

    int hours_worked;
    double hour_rate;

    // String company;
    
    public HourlyEmployee(int id, String name, String company,  int hours_worked, double hour_rate) {
        super(id, name, company);
        this.hour_rate = hour_rate;
        this.hours_worked = hours_worked;
    }
    
    public double calculate_payroll() {
        return this.hour_rate * hours_worked;
    }
    
    public boolean isNotNegative(int x) {
        return x >= 0;
    }
}


        Employee.NestedIf nif = new HourlyEmployee(1, "Nif", "Noolee", 20, 77.88);
        if (nif.isNotNegative(10)) {
            System.out.println("Число 10 не отрицательное.");
        }
        if (nif.isNotNegative(-12)) {
            System.out.println("Этo не будет выведено.");
        }

```
## Константы в интерфейсах

Интерфейсы можно использовать для импорта констант в несколько классов. Вы просто объявляете интерфейс, содержащий переменные с нужными значениями. При реализации интерфейса в классе имена переменных будут помещены в область констант. Поля для констант становятся открытыми и являются статическими и конечными (модификаторы public static final). При этом, если интерфейс не будет содержать никаких методов, то класс не будет ничего реализовывать. Хотя данный подход не рекомендуют использовать.

Хотя такие константы также не имеют модификаторов, но по умолчанию они имеют модификатор доступа public static final, и поэтому их значение доступно из любого места программы.

Применение констант:
```java

    public static void main(String[] args) {
          
        WaterPipe pipe = new WaterPipe();
        pipe.printState(1);
    }

class WaterPipe implements Stateable{
     
    public void printState(int n){
        if(n==OPEN)
            System.out.println("Water is opened");
        else if(n==CLOSED)
            System.out.println("Water is closed");
        else
            System.out.println("State is invalid");
    }
}

interface Stateable{
 
    int OPEN = 1;
    int CLOSED = 0;
     
    void printState(int n);
}


```


## Множественное наследование
Множественное наследование дает возможность создать класс, наследованный от нескольких суперклассов. В отличии от некоторых других популярных объектно-ориентированных языков программирования, таких как С++ в Java запрещено множественное наследование от классов. Java не поддерживает множественное наследование классов потому, что это может привести к ромбовидной проблеме.  И вместо того, чтобы искать способы решения этой проблемы, есть лучшие варианты, как мы можем добиться того же самого результата как множественное наследование.

## Композиция

Главное отличие между композицией и наследованием заключается в том, что композиция даёт возможность переиспользовать код без расширения существующего класса, как это происходит в случае с наследованием. Не менее важно и то, что композиция позволяет нам выполнять повторное использование кода даже из final-класса, в то время как унаследоваться от него мы не сможем. Есть и ещё кое-что: при композиции допускается использование кода из нескольких разных классов, а вот с наследованием это не сработает, ведь в языке программирования Java множественное наследование не поддерживается (правда, мы можем это сделать в C++).

Таким образом, в Java рекомендуется использовать преимущественно композицию, а не наследование.
```java
/**
 * 
 * в компании работают торговые партнеры, которым выплачивается фиксированная зарплата плюс комиссия, 
 * основанная на их продажах, поэтому мы создадим класс CommissionEmployee
 * @author janus
 *
 */
public class CommissionEmployee extends Employee implements IEmployee {

    /**
     * 
     */

    double commission;
    
    SalaryEmployee obj;

    public CommissionEmployee(SalaryEmployee o, double commission)
    {
        this.obj = o;
        
        this.commission = commission;
    }

    public double calculate_payroll() {
        double fixed = obj.calculate_payroll();
        return fixed + this.commission;
    }

}



```

