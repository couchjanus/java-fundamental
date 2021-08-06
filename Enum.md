# Перечисления Enum
Кроме отдельных примитивных типов данных и классов в Java есть тип enum или перечисление. Перечисления представляют набор логически связанных констант. 
Объявление перечисления происходит с помощью оператора enum, после которого идет название перечисления. Затем идет список элементов перечисления через запятую:
```java

public enum myEnum {
    WINTER,
    SUMMER,
    SPRING,
    FALL;
}

```
Enum - это отдельная структура. Он может находится в отдельном файле, а может быть частью класса. Но при этом enum не обязательно должен лежать в каком-либо классе. 

Все объекты, которые лежат в enum, принято писать большими буквами, это общепринятая практика. Если написать их маленькими ничего плохого не случится. 

Объекты, которые лежат в enum, пишутся через запятую:

В конце мы написали точку с запятой.
```java

enum Day{
  
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

```
При таком подходе мы как бы создаем еще один класс, только вместо слова "class" пишем "enum".
Перечисление фактически представляет новый тип, поэтому мы можем определить переменную данного типа и использовать ее:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Day current = Day.MONDAY;
        System.out.println(current);    // MONDAY
    }
}

```
## модификатор доступа

У enum есть модификатор доступа. Если Ваш enum не лежит внутри какого-нибудь класса, он должен быть объявлен public. Если сделать его private, Вы получите ошибку:

Если же enum будет "внутри" класса, он может быть объявлен private:

```java

// Enum Seasons:

public enum Seasons {
    WINTER,
    SUMMER,
    SPRING,
    FALL;
}

// main:

public class Test {
    public static void main(String[] args) {
        System.out.println(Seasons.WINTER);
        System.out.println(Seasons.SUMMER);
        System.out.println(Seasons.SPRING);
        System.out.println(Seasons.FALL);
    }
}

```
Когда мы вызываем объекты из enum, мы сначала пишем название самого enum, а потом через точку - название объекта: Seasons.WINTER

## enum удобно применять в операторах if или switch-case.
```java

public class Test {
    public static void main(String[] args) {
        // создали объект типа enum:
        Seasons arg = Seasons.FALL;
        // оператор switch, который печатает сообщение в зависимости от времени года
        // в case мы не должны писать полный путь (Seasons.FALL), а только название объекта - например, FALL: case WINTER:
        switch (arg)
        {
            case WINTER:
            System.out.println("It's winter! Christmas time!"); break;
            case SUMMER:
                System.out.println("It's summer! Let's go to the beach!"); break;
            case SPRING:
                System.out.println("It's spring! Easter is coming!"); break;
            case FALL:
                System.out.println("It's fall! Helloween is coming!"); break;
        }
    }
}

```

## Перечисления могут использоваться в классах для хранения данных:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Book b1 = new Book("War and Peace", "L. Tolstoy", Type.BELLETRE);
        System.out.printf("Book '%s' has a type %s", b1.name, b1.bookType);

        // С помощью конструкции switch..case можно проверить принадлежность значения bookType определенной константе перечисления.
         
        switch(b1.bookType){
            case BELLETRE:
                System.out.println("Belletre");
                break;
            case SCIENCE:
                System.out.println("Science");
                break;
            case SCIENCE_FICTION:
                System.out.println("Science fiction");
                break;
            case PHANTASY:
                System.out.println("Phantasy");
                break;
        }
    }
}
class Book{
  
    String name;
    Type bookType;
    String author;
  
    Book(String name, String author, Type type){
          
        bookType = type;
        this.name = name;
        this.author = author;
    }
}

```
Само перечисление объявлено вне класса, оно содержит четыре жанра книг. Класс Book кроме обычных переменных содержит также переменную типа перечисления. В конструкторе мы ее также можем присвоить, как и обычные поля класса.
```java

enum Type
{
    SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}

```
## Методы перечислений
### метод values()

Каждое перечисление имеет статический метод values(). Он возвращает массив всех констант перечисления:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Type[] types = Type.values();
        for (Type s : types) { System.out.println(s); }
    }
}
enum Type
{
    SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}

```

## реализация метода values() в классе Enum
```java
public static E[] values();
```
полной реализации метода в классе Enum нет, так как он синтетический (искусственно добавляется во время компиляции). Из документации узнаем, что метод просто возвращает массив всех значений перечисления в порядке их объявления.

## Методы name() и ordinal()
У каждого enum есть имя и порядковый номер. Получить их можно с помощью методов name() и ordinal()

### Метод ordinal() 

Метод ordinal() возвращает порядковый номер определенной константы (нумерация начинается с 0):
```java
System.out.println(Type.BELLETRE.ordinal());    // 1

// enum Color
enum Color {
    RED, GREEN, BLUE
}

System.out.println(Color.RED.name()); //output: RED

System.out.println(Color.RED.ordinal()); //output: 0

```
## реализация в классе Enum
```java

public abstract class Enum<E extends java.lang.Enum<E>>
        implements Comparable<E>, Serializable {
 
    private final String name;
 
    public final String name() {
        return name;
    }
 
    private final int ordinal;
 
    public final int ordinal() {
        return ordinal;
    }
 
    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
....
}

```
Конструктор невидим для разработчиков, но используется самой Java для корректной работы перечислений.
ключевое слово enum оно даёт понять программе, что вы хотите не просто класс, а именно перечисление.

## Методы equals(), hashcode(), toString(), finalize() и clone()

Enum переопределяет базовые методы класса Object. Так что их можно использовать сразу же в наших перечислениях.

### equals()
```java

boolean isEqualToItself = Color.RED.equals(Color.RED);
boolean isEqualToDifferentColor = Color.RED.equals(Color.GREEN);
 
System.out.println(isEqualToItself); //output: true
System.out.println(isEqualToDifferentColor);//output: false

```
###  hashCode()
```java

int hashOfRed = Color.RED.hashCode();
int hashOfGreen = Color.GREEN.hashCode();
 
System.out.println(hashOfRed); //output would be different every time: 366712642
System.out.println(hashOfGreen); //output would be different every time: 1829164700

```
Поскольку мы использовали hashCode(), каждый раз будет выводиться разное значение, сгенерированное автоматически. Когда мы запускали код, получили числа 366712642 и 1829164700. 

### toString()

```java
Color[] colors = Color.values();
System.out.println(Arrays.toString(colors)); //output: [RED, GREEN, BLUE]

String red = Color.RED.toString();
System.out.println(red); //output: RED

```
Посмотрим как они реализованы в классе Enum
```java

public String toString() {
    return name;
}
 
public final boolean equals(Object other) {
    return this==other;
}
 
public final int hashCode() {
    return super.hashCode();
}

```
- метод toString() возвращает имя значения перечисления. Назвали значение WHITE, это же значение и получим при вызове toString() или name();
- метод equals() сравнивает значения перечислений по ссылкам. Потому, что значения в перечислениях являются константными (уникальными), существует всего один экземпляр цвета RED, один цвета GREEN и один BLUE, значит ссылка на этот экземпляр будет всего одна, значит их можно сравнивать с помощью ==. Вы можете сами убедиться в этом, написав Color.RED == Color.RED или Color.GREEN == COLOR.BLUE;
- метод hashCode() использует стандартную реализацию из класса Object.

### clone()

```java 
protected final Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
}
```
метод clone() мы можем вызвать только внутри самого перечисления т.к. он помечен ключевым словом protected. Но даже если мы попытаемся сделать это, то ничего мы не получим, кроме CloneNotSupportedException. Нужно это для того чтобы нельзя было создать несколько экземпляров одного и того же перечисления. Ведь в реальной жизни у нас нет двух цифр "1", нет двух значений скорости света, так и с перечислениями.

### Метод valueOf()
Метод valueOf() - позволяет получить значения перечисления по его строковому представлению
Для получения значение перечисления по его строковому представлению у Enums есть метод valueOf(). 
```java

System.out.println(Color.valueOf("RED").ordinal()); //output: 0

// Если же такого значения в перечислении нет, то мы получим IllegalStateException

Color.valueOf("BLACK"); //output: java.lang.IllegalArgumentException: No enum constant Color.BLACK
```
Посмотрим на реализацию метода valueOf() в классе Enum
```java
public static E valueOf(String name);
```
как и в случае с values() этот метод тоже синтетический и поэтому полной реализации данного метода в классе Enum нет. В официальной документации написано, что метод просто возвращает значение перечисления по его строковому представлению. Проверка строгая, поэтому никаких пробелов вначале, в конце или между буквами не должно быть.

Есть еще один способ получить значение перечисления
```java
System.out.println(Enum.valueOf(Color.class, "BLUE").ordinal()); //output: 2
// но он является менее распространённым.

```
## Enum реализовывает интерфейс Comparable
Сделано это для того, чтобы перечисления можно было сравнивать друг с другом при сортировке. При этом сравнение происходит по ordinal() перечисления. 

## Интерфейсы Comparable и Сортировка

Интерфейс Comparable содержит один единственный метод int compareTo(E item), который сравнивает текущий объект с объектом, переданным в качестве параметра. Если этот метод возвращает отрицательное число, то текущий объект будет располагаться перед тем, который передается через параметр. Если метод вернет положительное число, то, наоборот, после второго объекта. Если метод возвратит ноль, значит, оба объекта равны.

### сравнение элементов перечисления с помощью метода compareTo()
```java
System.out.println(Color.GREEN.compareTo(Color.RED)); //output: 1
System.out.println(Color.GREEN.compareTo(Color.GREEN)); //output: 0
System.out.println(Color.GREEN.compareTo(Color.BLUE)); //output: -1
System.out.println(Color.RED.compareTo(Color.BLUE)); //output: -2

// Результат показывает как располагаются значения перечисления относительно друг друга:

// Число 1 означает, что значение GREEN находится правее на одну позицию от значения RED
// Число 0 означает, что значение GREEN равно само себе
// Число -1 означает, что значение GREEN находится левее от значения BLUE на одну позицию
// Число -2 означает, что значение RED находится левее от значения BLUE на две позиции

```
сравнивать перечисления можно только между своими типами. Нельзя сравнивать перечисления типа Color с перечислением типа Car. Мало того, что компилятор не даст вам это сделать с помощью своих подсказок так еще и в самом методе есть проверка на тип класса перечислений.


## Enum реализовывает интерфейс Serializable

Сериализация представляет процесс записи состояния объекта в поток, соответственно процесс извлечения или восстановления состояния объекта из потока называется десериализацией. Сериализация очень удобна, когда идет работа со сложными объектами.

Сериализовать можно только те объекты, которые реализуют интерфейс Serializable. Этот интерфейс не определяет никаких методов, просто он служит указателем системе, что объект, реализующий его, может быть сериализован.

Но как и в случае с clone() воспользоваться мы им не можем
```java

private void readObject(ObjectInputStream in) throws IOException,
    ClassNotFoundException {
    throw new InvalidObjectException("can't deserialize enum");
}
 
private void readObjectNoData() throws ObjectStreamException {
    throw new InvalidObjectException("can't deserialize enum");
}

```
причина того, что эти методы приватные да и к тому же бросают исключения при их вызове так же, что и в случае с clone(). Если бы эта возможность была открыта, тогда легко можно было бы сохранить перечисление в файл, затем считать его обратно и получить на выходе два экземпляра одного значения перечисления. Этот как два значения числа "1";


## Конструкторы и переменные

Перечисления, как и обычные классы, могут определять конструкторы, поля и методы:
```java

public class Program{
      
    public static void main(String[] args) {
          
        System.out.println(XColor.RED.getCode());        // #FF0000
        System.out.println(XColor.GREEN.getCode());      // #00FF00
        
    }
}
enum XColor{
    RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
    private String code;
    XColor(String code){
        this.code = code;
    }
    public String getCode(){ return code;}
}

```
Перечисление XColor определяет приватное поле code для хранения кода цвета, а с помощью метода getCode оно возвращается. Через конструктор передается для него значение. Следует отметить, что конструктор по умолчанию приватный, то есть имеет модификатор private. Любой другой модификатор будет считаться ошибкой. Поэтому создать константы перечисления с помощью конструктора мы можем только внутри перечисления.

## Также можно определять методы для отдельных констант:
```java

public class Program{
      
    public static void main(String[] args) {
          
        Operation op = Operation.SUM;
        System.out.println(op.action(10, 4));   // 14
        op = Operation.MULTIPLY;
        System.out.println(op.action(6, 4));    // 24
    }
}
enum Operation{
    SUM{
        public int action(int x, int y){ return x + y;}
    },
    SUBTRACT{
        public int action(int x, int y){ return x - y;}
    },
    MULTIPLY{
        public int action(int x, int y){ return x * y;}
    };
    public abstract int action(int x, int y);
}

```

## enum Country
У каждой страны есть своя валюта, чтобы её задать необходимо создать конструктор в enum Country и добавить поле currency
```java

enum Country {
    CANADA("CAD"), POLAND("PLN"), GERMANY("EUR");
 
    String currency;
 
    Country(String currency) {
        this.currency = currency;
    }
}

```
Допустим у нас появилась страна, у которой еще нет валюты. В этом случае нам необходимо будет добавить конструктор без параметров, или же конструктор по умолчанию.
```java

enum Country {
    CANADA("CAD"),
    POLAND("PLN"),
    GERMANY("EUR"),
    LAOPAPAS,
    ZIMKABU();
 
    String currency;
 
    Country(String currency) {
        this.currency = currency;
    }
 
    Country() {
    }
}

Пример использования enum Currency

for (Country country : Country.values()) {
    System.out.println(country + ", " + country.currency);
}

```

Поля и методы в перечислениях как и в классах могут иметь модификаторы доступа private, protected, default, public, а вот конструкторы в перечислениях всегда будут иметь модификатор  private. При попытке указать другой модификатор мы получим ошибку компиляции.
```java

public Country(String currency) { // Modifier 'public' is not allowed here
    this.currency = currency;
}

```
## Методы в перечислениях
В перечислениях можно использовать как обычные (общие) так и абстрактные методы, чтобы задать уникальную логику каждому значению перечисления.

## Общие методы в перечислениях
Добавим в перечисление метод hasCurrency(), который будет возвращать true или false в зависимости от того, есть валюта у страны или нет
```java

...
    boolean hasCurrency() {
        return currency != null;
    }

// И рассмотрим использование

for (Country country : Country.values()) {
    if (country.hasCurrency()) {
        System.out.println(country + " has currency, it's " + country.currency);
    } else {
        System.out.println(country + " has no currency");
    }
}
// Вывод в консоль

// CANADA has currency, it's CAD
// POLAND has currency, it's PLN
// GERMANY has currency, it's EUR
// LAOPAPAS has no currency
// ZIMKABU has no currency
```

## Абстрактные методы в перечислениях
```java

// добавим абстрактный метод void sayHello()

....
    abstract void sayHello();

// Теперь нам нужно реализовать этот метод во всех значениях перечисления


CANADA("CAD") {
    @Override
    void sayHello() {
        System.out.println("Hello");
    }
},
POLAND("PLN") {
    @Override
    void sayHello() {
        System.out.println("Cześć");
    }
},
GERMANY("EUR") {
    @Override
    void sayHello() {
        System.out.println("Hallo");
    }
},
LAOPAPAS {
    @Override
    void sayHello() {
        System.out.println("Lapapioooo");
    }
},
ZIMKABU() {
    @Override
    void sayHello() {
        System.out.println("Shakalaka");
    }
};

// И посмотрим на использование этого метода.

for (Country country : Country.values()) {
    System.out.print(country + " ");
    country.sayHello();
}
// Вывод в консоль

// CANADA Hello
// POLAND Cześć
// GERMANY Hallo
// LAOPAPAS Lapapioooo
// ZIMKABU Shakalaka
// Если же мы оставим одно значение не переопределённым то получим ошибку компиляции
// ZIMKABU(); 'Country' is abstract; cannot be instantiated
```
## Специальные коллекции для перечислений
мы знаем значения перечислений, знаем их количество и что новые значения не будут добавляться в перечисление в Runtime т.к. это невозможно. разработчики придумали специальную коллекцию для перечислений. Эта коллекция работает быстрее и эффективнее обычных, используя, особенности перечислений. Эта коллекция называется EnumSet. 

## Примеры создания EnumSet.

Метод allOf() создает EnumSet из всех значений заданого перечисления.
```java
import java.util.EnumSet;
import java.util.Set;

Set<Country> countries = EnumSet.allOf(Country.class);
System.out.println(countries); //output: [CANADA, POLAND, GERMANY, LAOPAPAS, ZIMKABU]

```
Метод of() создает EnumSet, который содержит заданные значения. Метод перегружен, принимая от одного значения до 5 и еще раз перегружен методом of(E first, E... rest), который принимает сколько угодно значений. Всё это нужно для оптимизации и быстродействия EnumSet.
```java
EnumSet.of(Country.GERMANY);
EnumSet.of(Country.CANADA, Country.GERMANY);
```
Метод range() создает EnumSet, который содержит все значения перечисления между указанными значениями.
```java
EnumSet<Country> range = EnumSet.range(Country.CANADA, Country.GERMANY);
System.out.println(range); //output: [CANADA, POLAND, GERMANY]
```    
Метод copyOf() возвращает копию указанного EnumSet, либо же копию любой другой коллекции этого перечисления.
```java
EnumSet<Country> canadaSet = EnumSet.of(Country.CANADA);
Set<Country> germanySet = Set.of(Country.GERMANY);
EnumSet<Country> canadaSetCopy = EnumSet.copyOf(canadaSet);
EnumSet<Country> germanySetCopy = EnumSet.copyOf(germanySet);
```
Изначально, в EnumSet у нас были три страны CANADA, POLAND и GERMANY. Ззатем метод complementOf() создал нам EnumSet который содержит значения LAOPAPAS, ZIMKABU, то есть все значения, которые НЕ содержатся в изначальной коллекции.
```java
EnumSet<Country> initialSet = EnumSet.of(Country.CANADA, Country.POLAND, Country.GERMANY);
EnumSet<Country> complement = EnumSet.complementOf(initialSet);
System.out.println(complement); //output: [LAOPAPAS, ZIMKABU]

```
Метод noneOf() возвращает пустой EnumSet заданного типа.
```java
EnumSet<Country> noneOf = EnumSet.noneOf(Country.class);
System.out.println(noneOf); //output: []

```
На самом деле EnumSet это абстрактный класс у которого 2 реализации - RegularEnumSet и JumboEnumSet. Выбор реализации определяется в методах создания EnumSet. Если количество элементов в перечислении, из которого вы хотите создать EnumSet, не превышает 64 то выбран будет RegularEnumSet, если элементов больше 64 - будет выбран JumboEnumSet.
Все операции в RegularEnumSet основаны на булевой логике. Все значения перечисления в RegularEnumSet умещаются в одну переменную типа long, максимальное колличество битов в котором равно 64. 
В JumboEnumSet также используется булевая логика, но вместе с массивом значений.
