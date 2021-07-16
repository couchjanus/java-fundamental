# Вложенные классы

Определение класса может размещаться внутри определения другого класса. Такие классы называются вложенными или внутренними. класс, который содержит внутренний класс, называется внешним классом.

## Синтаксис для записи вложенного класса. 
```java

// Здесь класс Outer – это внешний класс, а класс Inner – вложенный класс.

class Outer {
   class Inner {
   }
}

```
## причины использования вложенных классов:
- Это способ логической группировки классов, которые используются только в одном месте: если класс полезен только для одного класса, то логично встроить его в этот класс и сохранить их вместе. Вложение таких вспомогательных классов делает их пакет более оптимизированным.
- Это увеличивает инкапсуляцию: рассмотрим два класса верхнего уровня, A и B, где B требуется доступ к членам A, которые в противном случае были бы объявлены частными. Скрывая класс B внутри класса A, члены A могут быть объявлены закрытыми, и B может получить к ним доступ. Кроме того, сам B может быть скрыт от внешнего мира.
- Это может привести к более удобочитаемому и поддерживаемому коду: вложение небольших классов в классы верхнего уровня помещает код ближе к тому месту, где он используется.

Как и в случае с методами и переменными экземпляра, внутренний класс связан с экземпляром своего включающего класса и имеет прямой доступ к методам и полям этого объекта. Кроме того, поскольку внутренний класс связан с экземпляром, он не может сам определять какие-либо статические члены.

Объекты, которые являются экземплярами внутреннего класса, существуют внутри экземпляра внешнего класса:
```java

class OuterClass {
    ...
    class InnerClass {
        ...
    }
}

```
Экземпляр InnerClass может существовать только внутри экземпляра OuterClass и имеет прямой доступ к методам и полям включающего его экземпляра.

Чтобы создать экземпляр внутреннего класса, вы должны сначала создать экземпляр внешнего класса. Затем создайте внутренний объект внутри внешнего объекта:
```java

OuterClass outerObject = new OuterClass ();
OuterClass.InnerClass innerObject = outerObject.new InnerClass ();

```
Вложенные классы в Java делятся на два типа:
- Нестатические вложенные классы – нестатические члены класса.
- Статические вложенные классы – статические члены класса.

## Нестатические вложенные классы
Нестатические вложенные классы называют также внутренними классами (inner). Внутренний класс имеет доступ ко всем переменным и методам своего внешнего класса и может непосредственно ссылаться на них.

Внутренние классы создаются внутри окружающего класса:
```java

// внешний класс
class Outer {
    int outer_x = 9;
    
    void test() {
        Inner inner = new Inner();
        inner.display();
    }
    
    // внутренний класс
    class Inner {
        void display() {
            Log.i(TAG, outer_x);
        }
    }
}

class MainActivity...{
    // В методе onCreate() активности
    Outer outer = new Outer();
    outer.test();
}

```
Внутренний класс Inner определён в области видимости класса Outer. Поэтому любой код в классе Inner может непосредственно обращаться к переменной outer_x. Когда мы создаём экземпляр класса Outer и вызываем метод test(), то создаём также экземпляр класса Inner с вызовом метода display().

Внутренний класс можно определить не только на уровне класса, но и внутри метода или внутри тела цикла.

Если понадобится создать объект внутреннего класса не в статическом методе внешнего класса, тип этого объекта должен задаваться в формате ИмяВнешнегоКласса.ИмяВнутреннегоКласса.

Объект внутреннего класса связан с внешним объектом-создателем и может обращаться к его членам без каких-либо дополнительных описаний. Для внутренних классов доступны все элементы внешнего класса.

Если вам понадобится получить ссылку на объект внешнего класса, запишите имя внешнего класса, за которым следует точка, а затем ключевое слово this.

Внутренние классы — это механизм безопасности в Java. 
класс не может быть связан с модификатором доступа private, но если у нас есть класс как член другого класса, то внутренний класс может быть private. И это также используется для доступа к закрытым (private) членам класса.

## Статические вложенные классы
Если связь между объектом внутреннего класса и объектом внешнего класса не нужна, можно сделать внутренний класс статическим (static). Такой класс называют вложенным (nested).

- Статический вложенный класс вместе методами и переменными класса связан со своим внешним классом. 
- Статический вложенный класс и методы статического класса не могут напрямую ссылаться на переменные экземпляра или методы, определенные в его включающем классе: он может использовать их только через ссылку на объект. 

Статический класс объявляется ключевым словом static. 
```java

public class OuterClass {

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {

        }
    }
}

```
Создать статический вложенный класс можно так же, как и класс верхнего уровня:

StaticNestedClass staticNestedObject = new StaticNestedClass();

Статический вложенный класс взаимодействует с членами экземпляра своего внешнего класса (и других классов) так же, как и любой другой класс верхнего уровня. Фактически, статический вложенный класс поведенчески является классом верхнего уровня, который был вложен в другой класс верхнего уровня для удобства упаковки. 
```java

// OuterClass
public class OuterClass  {

    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }


}

public class Main {
    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");

        Main outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();        
        staticNestedObject.accessMembers(outerObject);

    }
}

```
Вложенный класс имеет доступ к членам своего внешнего класса, в том числе и к закрытым членам. 
```java

static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            System.out.println(staticOuterField);
        }
}
// Однако, внешний класс не имеет доступа к членам вложенного класса. 
static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
 
            System.out.println(staticOuterField);
        }
}

```
Вложенный класс при этом является членом внешнего класса.

Статический класс должен обращаться к нестатическим членам своего внешнего класса при помощи объекта, т.е. он не может обращаться напрямую на нестатические члены своего внешнего класса. 
```java

static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
}


```
## TopLevelClass
```java

// Top.java

public class Top {

    void accessMembers(OuterClass outer) {     
        // Compiler error: Cannot make a static reference to the non-static
        //     field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }  
}


  public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        Main outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();        
        staticNestedObject.accessMembers(outerObject);
        
        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        Top topLevelObject = new Top();        
        topLevelObject.accessMembers(outerObject);                
    }


```
## Доступ к частным (private) членам
внутренние классы также используются в Java для доступа к закрытым членам класса. 
```java

public class OuterClass {

    private int num = 2018;  
        
    public int getNum() {
            System.out.println("Это метод getnum внутреннего класса");
            return num;
    }
}

public class Main {

   public static void main(String[] args) {
   
      System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        System.out.println(innerObject.getNum());
        outerObject.test();
   }

}


```

# Абстрактные классы

в объектно-ориентированном программировании абстракция – это процесс скрытия деталей реализации от пользователя, предоставляя ему только функционал. Иными словами, пользователь будет владеть информацией о том, что объект делает, а не как он это делает.

В Java абстракция достигается с использованием абстрактных классов и интерфейсов.
 
Абстрактный класс похож на обычный класс. В абстрактном классе также можно определить поля и методы, но в то же время нельзя создать объект или экземпляр абстрактного класса. Абстрактные классы призваны предоставлять базовый функционал для классов-наследников. А производные классы уже реализуют этот функционал.

При определении абстрактных классов используется ключевое слово abstract:
```java

public abstract class Human{
 
    private String name;
     
    public String getName() { return name; }
}

```

Но главное отличие состоит в том, что мы не можем использовать конструктор абстрактного класса для создания его объекта. Например, следующим образом:
```java

Human h = new Human();

```
Кроме обычных методов абстрактный класс может содержать абстрактные методы. Такие методы определяются с помощью ключевого слова abstract и не имеют никакой реализации:
```java

public abstract void display();

```
если класс содержит хотя бы один абстрактный метод, то он обязан быть сам абстрактным.

Абстрактный метод не завершён. Он состоит только из объявления и не имеет тела:
```java

abstract void yourMethod();

```
По сути, мы создаём шаблон метода. Например, можно создать абстрактный метод для вычисления площади фигуры в абстрактном классе Фигура. А все другие производные классы от главного класса могут уже реализовать свой код для готового метода. Ведь площадь у прямоугольника и треугольника вычисляется по разным алгоритмам и универсального метода не существует.

Если вы объявляете класс, производный от абстрактного класса, но хотите иметь возможность создания объектов нового типа, вам придётся предоставить определения для всех абстрактных методов базового класса. Если этого не сделать, производный класс тоже останется абстрактным, и компилятор заставит пометить новый класс ключевым словом abstract.

Можно создавать класс с ключевым словом abstract даже, если в нем не имеется ни одного абстрактного метода. Это бывает полезным в ситуациях, где в классе абстрактные методы просто не нужны, но необходимо запретить создание экземпляров этого класса.

В тоже время абстрактный класс не обязательно должен иметь только абстрактные методы.

Производный класс обязан переопределить и реализовать все абстрактные методы, которые имеются в базовом абстрактном классе. Также следует учитывать, что если класс имеет хотя бы один абстрактный метод, то данный класс должен быть определен как абстрактный.

Зачем нужны абстрактные классы? Допустим, мы делаем программу для обслуживания банковских операций и определяем в ней три класса: Person, который описывает человека, Employee, который описывает банковского служащего, и класс Client, который представляет клиента банка. класс Client будет производными от класса Person. И так как все объекты будут представлять клиента банка, то напрямую мы от класса Person создавать объекты не будем. Поэтому имеет смысл сделать его абстрактным.
```java

abstract class Person {
     
    private String name;
     
    public String getName() { return name; }
    
    public Person(String name){
     
        this.name=name;
    }
  
    public abstract void display();
}

```
## Ключевое слово super
Ключевое слово super в Java используется тогда, когда подклассу требуется сослаться на его непосредственный супер класс.

У ключевого слова super имеются две общие формы:
1. Для вызова конструктора супер класса:
super(списокАргументов);
2. Для обращения к члену супер класса, скрываемому членом подкласса:
suреr.member;

### Вызов конструкторов супер класса с помощью ключевого слова super
Если в иерархии классов требуется передать параметры конструктору супер класса, то все подклассы должны передавать эти параметры вверх по иерархии. То есть из конструктора подкласса надо вызвать конструктор супер класса с помощью super(). Когда метод super() вызывается из подкласса, вызывается конструктор его непосредственного супер класса. Это справедливо даже для многоуровневой иерархии.

Вызов метода super() должен быть всегда в первом операторе, выполняемом в теле конструктора подкласса.
```java

class Client extends Person
{
    private String bank;
     
    public Client(String name, String company) {
        super(name);
        this.bank = company;
    }
     
    public void display(){
         
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), bank);
    }
}

class Employe extends Person
{
    private String bank;
     
    public Employe(String name, String company) {
        super(name);
        this.bank = company;
    }
     
    public void display(){
         
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), bank);
    }
}


public class Main{
      
    public static void main(String[] args) {
         
         Client client = new Client("Jhon doe", "ABC");
         System.out.println("\n Вызываем display, используя ссылку Client --");
         client.display();

             
         Client sam = new Client("Sam", "Leman Brothers");
         sam.display();
         Client bob = new Client("Bob", "Leman Brothers");
         bob.display();
    }
}


```
### Обращения к члену супер класса с помощью ключевого слова super
С помощью ключевого слова super можно обратиться к члену супер класса из класса наследника. Чаще всего это можно сделать не используя super.

В классе С объявлена переменная i типа int. В его наследнике классе D, тоже объявлена переменная i, но типа String. Из класса D мы можем напрямую обратиться только к переменной String i, которая перекрывает область видимости переменной int i. Для обращения же к int i, необходимо использовать слово super.

Похожая ситуация и с методами. В обоих классах определен метод print(). Если мы хотим из класса D вызвать метод print() класса С, используем слово super - super.print().
```java

public class C {
    public int i;
    public void print() {
        System.out.println("C.i = " + i);
    }
}

public class D extends C {
    public String i;

    public D(String a, int b) {
        i = a;
        super.i = b;
    }

    public void print() {
        System.out.println("D.i = " + i);
        super.print();
    }
}

public class UseSuper {
    public static void main(String[] args) {
        D d = new D("someString", 2);
        d.print();
        System.out.println(d.i);
    }
}

```
- Абстрактные классы в Java могут содержать или не содержать абстрактные методы, т.е. методы без тела (public void get();)
- Если класс имеет хотя бы один абстрактный метод, то класс должен быть объявлен абстрактным.
- Если класс объявлен абстрактным, его нельзя реализовать.
- Чтобы использовать абстрактный класс, вам нужно наследовать его из другого класса, обеспечить реализацию абстрактных методов в нём.
- Если вы наследуете абстрактный класс в Java, вам нужно обеспечить реализацию всех абстрактных методов в нём.

 
### Пример абстрактного класса. 
Чтобы создать абстрактный класс, просто используйте ключевое слово abstract перед ключевым словом class во время объявления класса.
```java

/* File name : Employee.java */

public abstract class Employee extends Person {
   

   private String address;
   private int number;
      
   public Employee(String name, String address, int number) {
         super(name);
         System.out.println("Собираем данные о работнике");
         this.address = address;
         this.number = number;
   }
      
   public double computePay() {
           System.out.println("Внутри Employee computePay");
           return 0.0;
   }
         
   public void mailCheck() {
            System.out.println("Отправляем чек " + super.getName() + " " + this.address);
   }

   public String toString() {
           return super.getName() + " " + address + " " + number;
   }
       
   public String getAddress() {
            return address;
   }
         
   public void setAddress(String newAddress) {
            address = newAddress;
   }
       
   public int getNumber() {
            return number;
   }
       
        
   public void display(){
            
           System.out.printf("Employee Name: %s \t Bank: %s \n", super.getName(), bank);
   }
}


``` 
помимо абстрактных методов класс Employee такой же, как и обычный класс в Java. Класс теперь абстрактный, но он ещё имеет 2 поля, семь методов и один конструктор.

Теперь попробуйте создать экземпляр класса Employee следующим образом:
```java

/* File name : AbstractDemo.java */
public class AbstractDemo {

   public static void main(String [] args) {
      /* Следующие действия неверны и выдадут ошибку */
      Employee e = new Employee("bla", "bla, bla", 43);
      e.mailCheck();
   }
}

```

## Наследование абстрактного класса
Рассмотрим наследоавние абстрактного класса в Java на примере. Вы можете наследовать класс Employee, как конкретный класс, следующим образом:
 
```java

/* File name : Salary.java */

public class Salary extends Employee {
      double salary;

      public Salary(String name, String address, int number, double salary) {
         super(name, address, number);
         this.salary = salary;
      }
      
      public void mailCheck() {
         System.out.println("Внутри mailCheck класса Salary ");
         System.out.println("Отправляем чек " + getName() + " с зарплатой " + salary);
      }
    
      public double getSalary() {
         return salary;
      }
      
      public void setSalary(double newSalary) {
         if(newSalary >= 0.0) {
            this.salary = newSalary;
         }
      }
      
      public double computePay() {
         System.out.println("Вычисляем заработную плату для " + getName());
         return this.salary/52;
      }
}

```
Здесь вы не можете создать экземпляр класса Employee, но вы можете создать экземпляр класса Salary, используя который вы сможете получить доступ ко всем полям и методам класса Employee.
```java

/* File name : Main.java */
public class Main {

   public static void main(String[] args) {
        
        Salary s = new Salary ("Mary Ann", "London, UK", 3, 3600.00);
        Employee e = new Salary ("Tom Cat", "NVC, USA", 2, 9400.00);
        System.out.println("Вызываем mailCheck, используя ссылку Salary --");
        s.mailCheck();
        System.out.println("\n Вызываем mailCheck, используя ссылку Employee --");
        e.mailCheck();
   }

}

```
## Абстрактный метод
Если вы хотите, чтобы класс содержал конкретный метод, но чтобы фактическая реализация этого метода определялась дочерними классами, вы можете объявить метод в родительском классе как абстрактный

Ключевое слово abstract используется для объявления метода абстрактным.
Вам нужно разместить ключевое слово abstract перед именем метода во время его объявления.
Абстрактный метод в Java содержит сигнатуру метода, но не содержит тела метода.
Вместо фигурных скобок у абстрактного метода будет точка с запятой (;) на конце.
```java

public abstract class Employee {
   private String name;
   private String address;
   private int number;
   
   public abstract double computedPay();
   // Остаток определения класса
}

```
Объявление метода абстрактным ведёт к двум последствиям:
- Класс, содержащий его, должен быть объявлен абстрактным.
- Любой класс, наследующий текущий класс, должен либо переопределить абстрактный метод, либо объявить себя абстрактным.
класс-потомок должен реализовать абстрактный метод, иначе у вас будет иерархия абстрактных классов, экземпляры которых нельзя будет создать.

класс Salary наследует класс Employee, тогда он должен реализовать метод computedPay():
```java

/* File name : Salary.java */
public class Salary extends Employee {
   private double salary;   // Годовая заработная плата
  
   public double computedPay() {
      System.out.println("Вычисляем заработную плату для " + getName());
      return salary/52;
   }
   // Остаток определения класса
}


```
Другим хрестоматийным примером является система геометрических фигур. В реальности не существует геометрической фигуры как таковой. Есть круг, прямоугольник, квадрат, но просто фигуры нет. Однако же и круг, и прямоугольник имеют что-то общее и являются фигурами:

```java

// абстрактный класс фигуры
abstract class Figure{
     
    float x; // x-координата точки
    float y; // y-координата точки
  
    Figure(float x, float y){
         
        this.x=x;
        this.y=y;
    }
    // абстрактный метод для получения периметра
    public abstract float getPerimeter();
    // абстрактный метод для получения площади
    public abstract float getArea();
}

// производный класс прямоугольника
class Rectangle extends Figure
{
    private float width;
    private float height;
  
    // конструктор с обращением к конструктору класса Figure
    Rectangle(float x, float y, float width, float height){
         
        super(x,y);
        this.width = width;
        this.height = height;
    }
     
    public float getPerimeter(){
         
        return width * 2 + height * 2;
    }
     
    public float getArea(){
         
        return width * height;
    }
}


```
Создавать объект на основе абстрактного класса нельзя.
```java

AbstractClass abstractClass = new AbstractClass();

```
Абстрактный класс не может содержать какие-либо объекты, а также абстрактные конструкторы и абстрактные статические методы. Любой подкласс абстрактного класса должен либо реализовать все абстрактные методы суперкласса, либо сам быть объявлен абстрактным.

абстрактный класс может содержать не только абстрактные, но и обычные методы.

Раннее мы создавали класс Фигура, у которого был метод вычисления площади фигуры. Метод ничего не делал, так как невозможно вычислить площадь неизвестной фигуры. Поэтому, этот метод можно сделать абстрактным, а в классах, производных от Фигуры, переопределить данный метод.

```java

// абстрактный класс Фигура
abstract class Figures {
    double dim1;
    double dim2;
    
    Figures(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    
    // абстрактный метод для вычисления площади
    abstract double area();
}

// Клас Треугольник
class Triangle extends Figures {
    Triangle(double a, double b) {
        super(a, b);
    }
    
    // переопределяем метод
    double area() {
        return dim1 * dim2 / 2;
    }
}


     // Figures figure = new Figures(10, 10); // так нельзя
        Triangle triangle = new Triangle(10, 8);

        Figures figure; // так можно, так как объект мы не создаем
        figure = triangle;
        System.out.println("Площадь равна " + figure.area());
```
Фигура - это абстрактное понятие и мы не можем создать универсальный метод для вычисления площади. Поэтому мы создаём другой класс Треугольник и пишем код, вычисляющий площадь треугольника (загляните в учебник геометрии). Также вы можете создать новый класс Прямоугольник и написать свой код для вычисления площади этой фигуры.

## Преобразование типов в языке Java

Суперклассы обычно размещаются выше подклассов, поэтому на вершине наследования находится класс Object, а в самом низу Employee и Client.

```java

public class Employe extends Person {

   private String company;
    
    public Employe(String name, String company) {
        super(name);
        this.company = company;
    }
    
    public String getCompany() {
      return company;
    }
    
    public void display(){
        
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), company);
    }

}


public class Client extends Person {

   private String bank;
   private int number;
   
    public Client(String name, String company,  int number) {
     
        super(name);
        this.bank = company;
        this.number = number;
    }
     
    public void display(){
         
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), bank);
    }

}

```

## восходящее преобразование
Объект подкласса также представляет объект суперкласса:
```java

Object sam = new Employe("Sam", "Oracle");
Object kate = new Client("Kate", "DeutscheBank", 2000);
Person bob = new Client("Bob", "DeutscheBank", 3000);
Person alice = new Employe("Alice", "Google");

```
Это так называемое восходящее преобразование (от подкласса внизу к суперклассу вверху иерархии) или upcasting. Такое преобразование осуществляется автоматически.

Обратное не всегда верно. Например, объект Person не всегда является объектом Employe или Client. Поэтому нисходящее преобразование или downcasting от суперкласса к подклассу автоматически не выполняется. В этом случае нам надо использовать операцию преобразования типов.
```java

Object sam = new Employe("Sam", "Oracle");
         
// нисходящее преобразование от Object к типу Employe

Employe emp = (Employe)sam;
emp.display();
System.out.println(emp.getCompany());

```
В данном случае переменная sam приводится к типу Employe. И затем через объект emp мы можем обратиться к функционалу объекта Employe.

Мы можем преобразовать объект Employee по всей прямой линии наследования от Object к Employee.

Примеры нисходящих перобразований:
```java

Object kate = new Client("Kate", "DeutscheBank", 2000);
((Person)kate).display();
         
Object sam = new Employe("Sam", "Oracle");
((Employee)sam).display();


Object kate = new Employe("Kate", "DeutscheBank");
Employe emp = (Employe) kate;
emp.display();
         
// или так

((Employe)kate).display();

```
В данном случае переменная типа Object хранит ссылку на объект Client. Мы можем без ошибок привести этот объект к типам Person или Client. Но при попытке преобразования к типу Employee мы получим ошибку во время выполнения. Так как kate не представляет объект типа Employee.

## Оператор instanceof
В примере выше мы явно видим, что переменная kate - это ссылка на объект Client, а не Employee. Однако нередко данные приходят извне, и мы можем точно не знать, какой именно объект эти данные представляют. Соответственно возникает большая вероятность столкнуться с ошибкой. И перед тем, как провести преобразование типов, мы можем проверить, а можем ли мы выполнить приведение с помощью оператора instanceof:
```java

Object kate = new Client("Kate", "DeutscheBank", 2000);

if(kate instanceof Employe){
      
    Employe employeKate = (Employe) kate;
    employeKate.display();
}
else{
                      
    System.out.println("Conversion is invalid");
}

```
Выражение kate instanceof Employe проверяет, является ли переменная kate объектом типа Employe. Но так как в данном случае явно не является, то такая проверка вернет значение false, и преобразование не сработает.

А выражение kate instanceof Client возвратило бы true:
```java

Object kate = new Client("Kate", "DeutscheBank", 2000);
if(kate instanceof Client){
               
    Client clientKate = (Client) kate;
    clientKate.display();
}
else{
                      
    System.out.println("Conversion is invalid");
}

// начиная с версии Java 16 мы можем упростить преобразование типов следующим образом:

Object kate = new Client("Kate", "DeutscheBank", 2000);
if(kate instanceof Client clientKate){
     
    clientKate.display();
}
else{
                      
    System.out.println("Conversion is invalid");
}

```
Выражение kate instanceof Client clientKate проверяет, представляет ли переменная kate класс Client, и если представляет (то есть оператор instanceof возвращает true), то создает переменную clientKate типа Client. И в дальнейшем мы можем использовать эту переменную clientKate и производить с ней различные операции.

## Анонимные внутренние классы

Анонимный внутренний класс — это внутренний класс, объявленный без имени класса. В случае анонимных внутренних классов в Java мы объявляем и создаем их в одно и то же время. Как правило, они используются всякий раз, когда Вам необходимо переопределить метод класса или интерфейса. Синтаксис анонимного внутреннего класса в Java выглядит следующим образом:

```java

AnonymousInner an_inner = new AnonymousInner() {
   public void my_method() {
      ........
      ........
   }   
};

```
Подобные классы очень часто встречаются в примерах на Android. 

### как переопределить метод класса с использованием анонимного внутреннего класса.
```java

abstract class AnonymousInner {
   public abstract void mymethod();
}

public class Main {

   public static void main(String args[]) {
      AnonymousInner inner = new AnonymousInner() {
         public void mymethod() {
            System.out.println("Это пример анонимного внутреннего класса");
         }
      };
      inner.mymethod(); 
   }
}


```