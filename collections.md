# Коллекции
 
Для хранения наборов данных в Java предназначены массивы. Однако их не всегда удобно использовать, прежде всего потому, что они имеют фиксированную длину. Эту проблему в Java решают коллекции. Однако суть не только в гибких по размеру наборах объектов, но в и том, что классы коллекций реализуют различные алгоритмы и структуры данных, например, такие как стек, очередь, дерево и ряд других.

Группа обычно имеет базовый набор функций — добавить, удалить, пройтись по всему списку, получить элемент. Но также возникает необходимость иметь дополнительные возможности, которые являются специфическими. Именно этим определяется разнообразие классов коллекций
Группа включает объекты в подавляющем большинстве случаев однотипных (одного класса). Хотя бывают исключения

Классы коллекций располагаются в пакете java.util, поэтому перед применением коллекций следует подключить данный пакет.

## Интерфейсы Collection
Хотя в Java существует множество коллекций, но все они образуют стройную и логичную систему. Во-первых, в основе всех коллекций лежит применение того или иного интерфейса, который определяет базовый функционал. Среди этих интерфейсов можно выделить следующие:
- Collection: базовый интерфейс для всех коллекций и других интерфейсов коллекций
- Queue: наследует интерфейс Collection и представляет функционал для структур данных в виде очереди
- Deque: наследует интерфейс Queue и представляет функционал для двунаправленных очередей
- List: наследует интерфейс Collection и представляет функциональность простых списков
- Set: также расширяет интерфейс Collection и используется для хранения множеств уникальных объектов
- SortedSet: расширяет интерфейс Set для создания сортированных коллекций
- NavigableSet: расширяет интерфейс SortedSet для создания коллекций, в которых можно осуществлять поиск по соответствию
- Map: предназначен для созданий структур данных в виде словаря, где каждый элемент имеет определенный ключ и значение. В отличие от других интерфейсов коллекций не наследуется от интерфейса Collection

Эти интерфейсы частично реализуются абстрактными классами:

- AbstractCollection: базовый абстрактный класс для других коллекций, который применяет интерфейс Collection
- AbstractList: расширяет класс AbstractCollection и применяет интерфейс List, предназначен для создания коллекций в виде списков
- AbstractSet: расширяет класс AbstractCollection и применяет интерфейс Set для создания коллекций в виде множеств
- AbstractQueue: расширяет класс AbstractCollection и применяет интерфейс Queue, предназначен для создания коллекций в виде очередей и стеков
- AbstractSequentialList: также расширяет класс AbstractList и реализует интерфейс List. Используется для создания связанных списков
- AbstractMap: применяет интерфейс Map, предназначен для создания наборов по типу словаря с объектами в виде пары "ключ-значение"

С помощью применения интерфейсов и абстрактных классов в Java реализуется широкая палитра классов коллекций - списки, множества, очереди, отображения и другие, среди которых можно выделить следующие:

- ArrayList: простой список объектов
- LinkedList: представляет связанный список
- ArrayDeque: класс двунаправленной очереди, в которой мы можем произвести вставку и удаление как в начале коллекции, так и в ее конце
- HashSet: набор объектов или хеш-множество, где каждый элемент имеет ключ - уникальный хеш-код
- TreeSet: набор отсортированных объектов в виде дерева
- LinkedHashSet: связанное хеш-множество
- PriorityQueue: очередь приоритетов
- HashMap: структура данных в виде словаря, в котором каждый объект имеет уникальный ключ и некоторое значение
- TreeMap: структура данных в виде дерева, где каждый элемент имеет уникальный ключ и некоторое значение

## Интерфейс Collection
Интерфейс Collection является базовым для всех коллекций, определяя основной функционал:
```java

public interface Collection<E> extends Iterable<E>{
 
    // определения методов
}

```
Интерфейс Collection является обобщенным и расширяет интерфейс Iterable, поэтому все объекты коллекций можно перебирать в цикле по типу for-each.

Среди методов интерфейса Collection можно выделить следующие:

- boolean add (E item): добавляет в коллекцию объект item. При удачном добавлении возвращает true, при неудачном - false
- boolean addAll (Collection<? extends E> col): добавляет в коллекцию все элементы из коллекции col. При удачном добавлении возвращает true, при неудачном - false
- void clear (): удаляет все элементы из коллекции
- boolean contains (Object item): возвращает true, если объект item содержится в коллекции, иначе возвращает false
- boolean isEmpty (): возвращает true, если коллекция пуста, иначе возвращает false
- Iterator<E> iterator (): возвращает объект Iterator для обхода элементов коллекции
- boolean remove (Object item): возвращает true, если объект item удачно удален из коллекции, иначе возвращается false
- boolean removeAll (Collection<?> col): удаляет все объекты коллекции col из текущей коллекции. Если текущая коллекция изменилась, возвращает true, иначе возвращается false
- boolean retainAll (Collection<?> col): удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в коллекции col. Если текущая коллекция после удаления изменилась, возвращает true, иначе возвращается false
- int size (): возвращает число элементов в коллекции
- Object[] toArray (): возвращает массив, содержащий все элементы коллекции

Все методы, которые имеются в интерфейсе Collection, реализуются всеми коллекциями, поэтому в целом общие принципы работы с коллекциями будут одни и те же. Единообразный интерфейс упрощает понимание и работу с различными типами коллекций. Так, добавление элемента будет производиться с помощью метода add, который принимает добавляемый элемент в качестве параметра. Для удаления вызывается метод remove(). Метод clear будет очищать коллекцию, а метод size возвращать количество элементов в коллекции.

## Наборы данных Collection
В парадигме объектно-ориентированного программирования поддерживается концепция инкапсуляции данных внутри классов. Однако это не означает, что способы размещения данных играют менее важную роль. Конечно же, используемая структура данных зависит от решаемой задачи. Способ организации данных внутри класса имеет очень важное значение для реализации методов и достижения максимальной производительности.

Интерфейс Collection является фундаментальным интерфейсом для классов Java, поддерживающих наборы данных (коллекции), в котором объявлены следующие 2 основных метода :
```java

public interface Collection<E>
{
    boolean add (E element();
    Iterator <E> iterator();
}

```
Помимо них, интерфейс Collection имеет еще несколько методов.

## Метод add()
Метод add() добавляет элемент к набору и возвращает либо значение true, если набор данных изменился, либо false в противном случае. Например, если попытаться добавить в множество уже существующий объект, то запрос add() будет проигнорирован, поскольку по определению множество не может содержать дублирующие объекты.
## Метод iterator()
Метод iterator() возвращает объект-итератор, реализующий интерфейс Iterator, который используется для последовательного обращения к элементам набора данных.


## Класс ArrayList и интерфейс List

Для создания простых списков применяется интерфейс List, который расширяет функцональность интерфейса Collection. Некоторые наиболее часто используемые методы интерфейса List:
- void add(int index, E obj): добавляет в список по индексу index объект obj
- boolean addAll(int index, Collection<? extends E> col): добавляет в список по индексу index все элементы коллекции col. Если в результате добавления список был изменен, то возвращается true, иначе возвращается false
- E get(int index): возвращает объект из списка по индексу index
- int indexOf(Object obj): возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1
- int lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта obj в список. Если объект не найден, то возвращается -1
- ListIterator<E> listIterator (): возвращает объект ListIterator для обхода элементов списка
- static <E> List<E> of(элементы): создает из набора элементов объект List
- E remove(int index): удаляет объект из списка по индексу index, возвращая при этом удаленный объект
- E set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index
- void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp
- List<E> subList(int start, int end): получает набор элементов, которые находятся в списке между индексами start и end

## Класс ArrayList
По умолчанию в Java есть встроенная реализация этого интерфейса - класс ArrayList. Класс ArrayList представляет обобщенную коллекцию, которая наследует свою функциональность от класса AbstractList и применяет интерфейс List. ArrayList представляет простой список, аналогичный массиву, за тем исключением, что количество элементов в нем не фиксировано.

ArrayList имеет следующие конструкторы:
- ArrayList(): создает пустой список
- ArrayList(Collection <? extends E> col): создает список, в который добавляются все элементы коллекции col.
- ArrayList (int capacity): создает список, который имеет начальную емкость capacity

Емкость в ArrayList представляет размер массива, который будет использоваться для хранения объектов. При добавлении элементов фактически происходит перераспределение памяти - создание нового массива и копирование в него элементов из старого массива. Изначальное задание емкости ArrayList позволяет снизить подобные перераспределения памяти, тем самым повышая производительность.

Используем класс ArrayList и некоторые его методы в программе:
```java

import java.util.ArrayList;
 
public class Program{
      
    public static void main(String[] args) {

        // объект ArrayList типизируется классом String, поэтому список будет хранить только строки. Поскольку класс ArrayList применяет интерфейс Collection<E>, то мы можем использовать методы данного интерфейса для управления объектами в списке.
          
        ArrayList<String> people = new ArrayList<String>();

        // Для добавления вызывается метод add. С его помощью мы можем добавлять объект в конец списка: people.add("Tom"). Также мы можем добавить объект на определенное место в списке, например, добавим объект на второе место (то есть по индексу 1, так как нумерация начинается с нуля): people.add(1, "Bob")

        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add(1, "Bob"); // добавляем элемент по индексу 1
          
        // Получить определенный элемент по индексу мы можем с помощью метода get(): String person = people.get(1);, а установить элемент по индексу с помощью метода set: people.set(1, "Robert");

        System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Robert"); // установка нового значения для 2-го объекта
        
        // Метод size() позволяет узнать количество объектов в коллекции.
        System.out.printf("ArrayList has %d elements \n", people.size());

        for(String person : people){
          
            System.out.println(person);
        }
        // Проверку на наличие элемента в коллекции производится с помощью метода contains. А удаление с помощью метода remove. И так же, как и с добавлением, мы можем удалить либо конкретный элемент people.remove("Tom");, либо элемент по индексу people.remove(0); - удаление первого элемента.

        // проверяем наличие элемента
        if(people.contains("Tom")){
         
            System.out.println("ArrayList contains Tom");
        }
          
        // удалим несколько объектов
        // удаление конкретного элемента
        people.remove("Robert");
        // удаление по индексу
        people.remove(0);
          
        // С помощью метода toArray() мы можем преобразовать список в массив объектов.
        Object[] peopleArray = people.toArray();

        // поскольку класс ArrayList реализует интерфейс Iterable, то мы можем пробежаться по списку в цикле аля for-each: for(String person : people).

        for(Object person : peopleArray){
         
            System.out.println(person);
        }
    }
}

```

Хотя мы можем свободно добавлять в объект ArrayList дополнительные объекты, в отличие от массива, однако в реальности ArrayList использует для хранения массив. По умолчанию данный массив предназначен для 10 объектов. Если в процессе программы добавляется гораздо больше, то создается новый массив, который может вместить в себя все количество. Подобные перераспределения памяти уменьшают производительность. Поэтому если мы точно знаем, что у нас список не будет содержать больше определенного количества элементов, например, 25, то мы можем сразу же явным образом установить это количество, либо в конструкторе: 
```java

ArrayList<String> people = new ArrayList<String>(25);
// либо с помощью метода ensureCapacity: 
people.ensureCapacity(25);

```

## Интерфейс List
 
Интерфейс List расширяет Collection и объявляет поведение коллекции, которая хранит последовательность элементов.

Элементы могут быть вставлены или доступны по их позиции в списке, используя индекс на основе нуля.
Список может содержать повторяющиеся элементы.

Некоторые из методов List будут генерировать UnsupportedOperationException, если коллекция не может быть изменена, и ClassCastException генерируется, когда один объект несовместим с другим.

В дополнение к методам, определенным в Collection, List определяет некоторые из своих:
1. void add(int index, Object obj) - Вставляет obj в вызывающий список по индексу, переданному в index. Любые ранее существовавшие элементы, находящиеся в пределах или за пределами точки вставки, сдвигаются вверх. Таким образом, элементы не перезаписываются.
2. boolean addAll(int index, Collection c) - Вставляет все элементы c в вызывающий список по индексу, переданному в index. Любые ранее существовавшие элементы, находящиеся в пределах или за пределами точки вставки, сдвигаются вверх. Таким образом, элементы не перезаписываются. Возвращает true, если вызывающий список изменяется, в противном случае возвращает false.
3. Object get(int index) - Возвращает объект, хранящийся в указанном индексе в вызывающей коллекции.
4. int indexOf(Object obj) - Возвращает индекс первого экземпляра obj в вызывающем списке. Если obj не является элементом списка, возвращается .1.
5. int lastIndexOf(Object obj - Возвращает индекс последнего экземпляра obj в вызывающем списке. Если obj не является элементом списка, возвращается .1.
6. ListIterator listIterator( ) - Возвращает итератор в начало вызывающего списка.
7. ListIterator listIterator(int index) - Возвращает итератор в вызывающий список, который начинается с указанного индекса.
8. Object remove(int index) - Удаляет элемент, находящейся на позиции index, из вызывающего списка и возвращает удалённый элемент. Полученный список уплотняется. То есть индексы последующих элементов уменьшаются на единицу.
9. Object set(int index, Object obj) - Присваивает obj к местоположению, указанным index’ом в вызывающем списке.
10. List subList(int start, int end) - Возвращает список, содержащий элементы от начала до конца .1 в вызывающем списке. Элементы в возвращаемом списке также ссылаются на вызывающий объект.


Несколько методов из различных реализаций классов из методов коллекций:
```java

import java.util.*;


public class CollectionsDemo {

   public static void main(String[] args) {

      List a1 = new ArrayList();
      a1.add("Tom");
      a1.add("Mark");
      a1.add("Kate");
      System.out.println("ArrayList Элементы");
      System.out.print("\t" + a1);

      List l1 = new LinkedList();
      l1.add("Tom");
      l1.add("Mark");
      l1.add("Kate");
      System.out.println();
      System.out.println("LinkedList Элементы");
      System.out.print("\t" + l1);
   }

}

```

## Демонстрация различных операций над списком
```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
/**
 * 
 */
public class Main {
 
    public static void main(String[] args) {
 
        List<MyClass> list = new ArrayList<MyClass>();
 
        list.add(new MyClass("Василий"));
        list.add(new MyClass("Павел"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Петр"));
        list.add(new MyClass("Анжелика"));
 
        printCollection("Оригинал", list);
 
        // Смешивание
        Collections.shuffle(list);
        printCollection("Смешивание", list);
 
        // Обратный порядок
        Collections.reverse(list);
        printCollection("Обратный порядок", list);
 
        // "Проворачивание" на определенное количество
        Collections.rotate(list, 2); // Число может быть отрицательным - тогда порядок будет обратный
        printCollection("Проворачивание", list);
 
        // Обмен элементов
        Collections.swap(list, 0, list.size()-1);
        printCollection("Обмен элементов", list);
 
        // Замена
        Collections.replaceAll(list, new MyClass("Андрей"), new MyClass("Алексей"));
        printCollection("Замена", list);
 
        // Копирование - здесь обязательно надо иметь нужные размеры
        List<MyClass> list2 = new ArrayList<MyClass>(list.size());
        // Поэтому заполняем список. Хоть чем-нибудь.
        for(MyClass mc : list) {
            list2.add(null);
        }
        // Компируем из правого аргумента в левый
        Collections.copy(list2, list);
        printCollection("Копирование", list2);
 
        // Полная замена
        Collections.fill(list2, new MyClass("Антон"));
        printCollection("Полная замена", list2);
 
    }
 
    private static void printCollection(String title, List<MyClass> list) {
        System.out.println(title);
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
    }
 
}
 
/**
 * пример произвольного класса
 */
public class MyClass {
 
    private String name;
 
    public MyClass(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return name;
    }
 
    // Без методов equals и hashCode не будет замены в списках
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyClass other = (MyClass) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}

```

## Класс LinkedList
 
Обобщенный класс LinkedList<E> представляет структуру данных в виде связанного списка. Он наследуется от класса AbstractSequentialList и реализует интерфейсы List, Dequeue и Queue. То есть он соединяет функциональность работы со списком и фукциональность очереди.

Класс LinkedList имеет следующие конструкторы:
- LinkedList(): создает пустой список
- LinkedList(Collection<? extends E> col): создает список, в который добавляет все элементы коллекции col
- LinkedList содержит все те методы, которые определены в интерфейсах List, Queue, Deque. Некоторые из них:
- addFirst() / offerFirst(): добавляет элемент в начало списка
- addLast() / offerLast(): добавляет элемент в конец списка
- removeFirst() / pollFirst(): удаляет первый элемент из начала списка
- removeLast() / pollLast(): удаляет последний элемент из конца списка
- getFirst() / peekFirst(): получает первый элемент
- getLast() / peekLast(): получает последний элемент

## применение связанного списка:

```java

import java.util.LinkedList;
 
public class Program{
      
    public static void main(String[] args) {
          
        LinkedList<String> states = new LinkedList<String>();
          
        // добавим в список ряд элементов
        states.add("Germany");
        states.add("France");
        states.addLast("Great Britain"); // добавляем на последнее место
        states.addFirst("Spain"); // добавляем на первое место
        states.add(1, "Italy"); // добавляем элемент по индексу 1
        
        System.out.printf("List has %d elements \n", states.size());
        System.out.println(states.get(1));
        states.set(1, "Portugal");
        for(String state : states){
          
            System.out.println(state);
        }
        // проверка на наличие элемента в списке
        if(states.contains("Germany")){
          
            System.out.println("List contains Germany");
        }
          
        states.remove("Germany");
        states.removeFirst(); // удаление первого элемента
        states.removeLast(); // удаление последнего элемента
          
        LinkedList<Person> people = new LinkedList<Person>();
        people.add(new Person("Mike"));
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));
        people.remove(1); // удаление второго элемента
          
        for(Person p : people){
          
            System.out.println(p.getName());
        }
        Person first = people.getFirst();
        System.out.println(first.getName()); // вывод первого элемента
    }
}
class Person{
      
    private String name;
    public Person(String value){
          
        name=value;
    }
    String getName(){return name;}
}

```
Здесь создаются и используются два списка: для строк и для объектов класса Person. При этом в дополнение к методам addFirst/removeLast и т.д., нам также доступны стандартные методы, определенные в интерфейсе Collection: add(), remove, contains, size и другие. Поэтому мы можем использовать разные методы для одного и того же действия. Например, добавление в самое начало списка можно сделать так: states.addFirst("Spain");, а можно сделать так: states.add(0, "Spain");


## Итераторы
 
Одним из ключевых методов интерфейса Collection является метод Iterator<E> iterator(). Он возвращает итератор - то есть объект, реализующий интерфейс Iterator.

## Интерфейс Iterator

В интерфейсе Iterator определены следующие три основных метода:
```java

public interface Iterator<E>
{
    E next;
    boolean hasNext();
    void remove();
}

```
Реализация интерфейса Iterator предполагает, что с помощью вызова метода next() можно получить следующий элемент. С помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли конец коллекции. И если элементы еще имеются, то hasNext() вернет значение true. Метод hasNext() следует вызывать перед методом next(), так как при достижении конца коллекции метод next() выбрасывает исключение NoSuchElementException. И метод remove() удаляет текущий элемент, который был получен последним вызовом next().

### Iterator для перебора коллекции, метод hasNext
```java

import java.util.*;

public class CollectionApp
{
    public static void main(String[] args)
    {
        List<String> states = new ArrayList<String>();
        states.add("Германия");
        states.add("Франция");
        states.add("Италия");
        states.add("Испания");
         
        Iterator<String> iter = states.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}

```
### Цикл for each

```java

for (String element : list) {
    System.out.println(element.toString());
}

```
Компилятор преобразует цикл "for each" в обычный цикл с итератором. Цикл "for each" работает с любым объектом, реализующим интерфейс Iterable, в котором объявлен единственный метод
```java

public interface Iterable <E>
{
    Iterator <E> iterator();
}

```
Интерфейс Collection расширяет интерфейс Iterable. Поэтому цикл "for each" можно использовать для любого набора данных из стандартной библиотеки.

## Порядок следования элементов в итераторе
Порядок перебора элементов коллекции зависит от типа и набора элементов. Если используется объект ArrayList, то итератор начинает с индекса 0 и увеличивает индекс на 1 на каждом шаге. Если объект имеет тип HashSet, то порядок следования элементов коллекции может оказаться случайным.

При использовании итератора Iterator, можно быть уверенным, что он переберет все элементы, но строить предположения о порядке, в котором элементы будут извлекаться, по меньшей мере рискованно. В большинстве случаев порядок следования элементов не имеет никакого значения.

## Удаление элементов итератором
Метод remove() интерфейса Iterable удаляет элемент, возвращенный в результате последнего вызова метода next(). В большистве случаев это правильно, т.к. необходимо проверить элемент перед принятием решения об его удалении. Пример удаления первого элемента набора строк с использованием итератора :
```java

Iterator it = states.iterator();
it.next();
it.remove();

```
Необходимо помнить, что перед вызовом next() и удалением remove() существует строгая взаимосвязь. Нельзя вызывать метод remove(), если ему не предшествовал вызов метода next(). При попытке сделать это будет сгенерировано исключение IllegalStateException.

При необходимости удаления двух соседних элементов нельзя дважды подряд вызвать метод remove().
```java

it.remove();
it.remove();  // Ошибка

```
Нужно сначала вызвать метод next(), чтобы итератор (указатель) встал на элемент, подлежащий удалению.
```java

it.remove();
it.next();
it.remove();  // Правильно

```
## Универсальные вспомогательные методы, contains
Интерфейсы Collection и Iterable являются универсальными, поэтому для них можно создавать универсальные методы, работающие для любых наборов данных. Пример универсального метода contains, проверяющего наличие элемента obj в наборе данных :
```java

public static <E> boolean contains (Collection <E> c, Object obj)
{
    for (E element : c)
        if (element.equals(obj))
            return true;
    return false;
}
it.next();
it.remove();  // Правильно

```
## Интерфейс ListIterator
Интерфейс Iterator предоставляет ограниченный функционал. Гораздо больший набор методов предоставляет другой итератор - интерфейс ListIterator. Данный итератор используется классами, реализующими интерфейс List, то есть классами LinkedList, ArrayList и др.

Интерфейс ListIterator расширяет интерфейс Iterator и определяет ряд дополнительных методов:
- void add(E obj): вставляет объект obj перед элементом, который должен быть возвращен следующим вызовом next()
- boolean hasNext(): возвращает true, если в коллекции имеется следующий элемент, иначе возвращает false
- boolean hasPrevious(): возвращает true, если в коллекции имеется предыдущий элемент, иначе возвращает false
- E next(): возвращает текущий элемент и переходит к следующему, если такого нет, то генерируется исключение NoSuchElementException
- E previous(): возвращает текущий элемент и переходит к предыдущему, если такого нет, то генерируется исключение NoSuchElementException
- int nextIndex(): возвращает индекс следующего элемента. Если такого нет, то возвращается размер списка
- int previousIndex(): возвращает индекс предыдущего элемента. Если такого нет, то возвращается число -1
- void remove(): удаляет текущий элемент из списка. Таким образом, этот метод должен быть вызван после методов next() или previous(), иначе будет сгенерировано исключение IlligalStateException
- void set(E obj): присваивает текущему элементу, выбранному вызовом методов next() или previous(), ссылку на объект obj


## Используем ListIterator:

```java

import java.util.*;
 
public class Program {
 
    public static void main(String[] args) {
         
        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");
         
        ListIterator<String> listIter = states.listIterator();
         
        while(listIter.hasNext()){
         
            System.out.println(listIter.next());
        }
        // сейчас текущий элемент - Испания
        // изменим значение этого элемента
        listIter.set("Португалия");
        // пройдемся по элементам в обратном порядке
        while(listIter.hasPrevious()){
         
            System.out.println(listIter.previous());
        }    
    }
}

```

ListIterator доступен только для тех коллекций, которые реализуют интерфейс List.

```java

import java.util.*;
public class IteratorDemo {

   public static void main(String args[]) {
      // Создаём список массивов
      ArrayList al = new ArrayList();
      
      // Добавляем элементы к списку массивов
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");

      // Используем итератор, для отображения элементов al
      System.out.print("Начальное содержание al: ");
      Iterator itr = al.iterator();
      
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();
      
      // Изменяем повторяемые объекты
      ListIterator litr = al.listIterator();
      
      while(litr.hasNext()) {
         Object element = litr.next();
         litr.set(element + "+");
      }
      System.out.print("Изменённое содержание al: ");
      itr = al.iterator();
      
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();

      // Теперь, отобразим список задом наперёд
      System.out.print("Изменённый список задом наперёд: ");
      
      while(litr.hasPrevious()) {
         Object element = litr.previous();
         System.out.print(element + " ");
      }
      System.out.println();
   }
}

```
коллекция позволяет работать с группой объектов и специализация коллекции определяется требованиями к самим данным и к тем операциям, которые нужно использовать при работе с данными.


## Пример использования коллекций
```java

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
 
public class ExampleCollection 
{
    public static void main(String[] args) {
        // Создаем коллекции
        // берем класс java.util.ArrayList и создаем его экземпляр. 
        // Т.к. этот класс имплементирует интерфейс java.util.Collection, 
        // то у него есть все методы, которые в интерфейсе описаны. 

        Collection col1 = createFirstCollection();
        Collection col2 = createSecondCollection();
 
        // проход по коллекции
        System.out.println("============= Проход по коллекции");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
 
        System.out.println();
        // проход по коллекции через итератор
        // конструкция, которая позволяет обратиться к каждому элементу коллекции Обратите внимание — т.к. все классы наследуются от класса Object, то любой элемент в коллекции может рассматриваться как Object.
        // при каждом цикле мы помещаем в переменную o ссылку на следующий объект в коллекции. Т.е. у нас получается две ссылки — одна внутри самой коллекции, вторая — наша переменная .

        System.out.println("============= Проход по коллекции через итератор");
        for (Iterator it = col1.iterator(); it.hasNext(); ) {
            String s = (String)it.next();
            System.out.println("Item:" + s);
        }
        System.out.println();
 
        // Групповые операции
        System.out.println();
        System.out.println("============= Групповые операции");
        // Можно проверить сожержаться ли ВСЕ элементы col2 в col
        if(col1.containsAll(col2)) {
            System.out.println("Коллекция col содержит все от col2");
        }

        // Добавление в коллекцию происходит очень просто — вызываем метод add. В коллекцию можно поместить объект любого класса, но нельзя туда поместить элементарный тип — int, char, long. 

        System.out.println("============= Добавление всех элементов в col1 из col2");
        // Можно добавить элементы из col2 в col1
        col1.addAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        
        System.out.println("============= Удаление всех элементов col2, которые есть в col1");
        // Можно удалить ВСЕ элементы col2, которые есть в col1
        col1.removeAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        
        // Пересоздаем коллекции
        col1 = createFirstCollection();
        col2 = createSecondCollection();
        System.out.println("============= Удаление элементов из col1, которых нет в col2");
        col1.retainAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("============= Очистка коллекции - не будет элементов");
        col1.clear();
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();
 
        // Удаление элемента коллекции
        // java.util.Iterator — это интерфейс, который позволяет перемещаться по списку элементов. 
        // При вызове метода iterator() вы получаете указатель на начало коллекции, но не на первый элемент. 
        // Метод итератора hasNext() возвращает true в случае, если итератор может переместиться к следующему элементу (есть следующий за текущим), 
        // если получаем false — значит элементов больше нет.
        // Метод итератора next() перемещается на следующий элемент и возвращает его значение — объект типа Object. 
        // Т.к. в коллекции находятся объекты типа String, то преобразуем ссылку на объект типа Object в ссылку на объект типа String.
        // с объектами мы работаем через ссылки и т.к. реальный объект в коллекции имеет тип String, то приведение не вызовет ошибок. Такое приведение позволит работать теперь с объектов как со строкой.
        
        // Снова создаем коллекцию
        col1 = createFirstCollection();
        // Удаляем один элемент
        col1.remove("1");
        System.out.println("============= Удаляем элемент '1' - его не будет в списке");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        // Здесь мы удаляем элемент из коллекции и передаем ДРУГОЙ объект. 
        // Элемент, который мы передали методу remove и объект, который находится в коллекции — это ОДИНАКОВЫЕ, но РАЗНЫЕ объекты. 
        // По сути из коллекции удаляется объект, для которого метод equals возвращает true.

        // Удаление коллекции через итератор
        // Снова создаем коллекцию
        col1 = createFirstCollection();
        System.out.println("============= Удаление через итератор");
 
        // Каждый раз после удаления проверяем не пуста ли наша коллекция (метод isEmpty) и если это не так, выставляем итератор в начало, переставляем его на первый элемент и удаляем.

        while(!col1.isEmpty()) {
            Iterator it = col1.iterator();
            Object o = it.next();
            System.out.println("Удаляем:" + o);
            // Удаляем элемент
            it.remove();
        }


    }
 
    // Первая коллекция
    private static Collection createFirstCollection() {
        // Создать коллекцию на основе стандартного класса ArrayList
        Collection col = new ArrayList();
        // Добавление в коллекцию
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        col.add("6");
        col.add("7");
        return col;
    }
 
    // Вторая коллекция
    private static Collection createSecondCollection() {
        // Создать коллекцию на основе стандартного класса ArrayList
        Collection col2 = new ArrayList();
        col2.add("1");
        col2.add("2");
        col2.add("3");
        return col2;
    }
}

```

Метод итератора коллекции и метод toArray используются для получения всех элементов коллекции. Первый возвращает объект Iterator, а второй возвращает массив, содержащий все элементы коллекции. Интерфейс Iterator скрывает структуру данных базовой коллекции и обеспечивает итерацию через различные типы. Унифицированный интерфейс коллекции, интерфейс Iterator объявляет следующие методы:


## Используйте Iterator для обхода коллекций
```java


import java.util.*;

public class Visitor {

    public static void print(Collection<? extends Object> c) {
        Iterator<? extends Object> it = c.iterator();
        // Перебираем все элементы в коллекции
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
    // То же, что и метод print (), оба используются для обхода коллекции, разница в том, что printWithForeach) использует оператор foreach для упрощения кода
    public static void printWithForeach(Collection<? extends Object> c) {
        for (Object element : c) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();// Создать набор
        set.add("Tom");
        set.add("Marry");
        set.add("Jack");
        print(set);

        ArrayList<String> list = new ArrayList<String>();// Создать список
        list.add("Linda");
        list.add("Mary");
        list.add("Rose");
        print(list);

        ArrayDeque<String> quene = new ArrayDeque<String>();// создаем очередь
        quene.add("Tom");
        quene.add("Mike");
        quene.add("Jack");
        print(quene);

        //map.entrySet () метод возвращает коллекцию, в которой хранятся элементы Map.Entry
        // Каждый элемент Map.Entry представляет пару ключей / значений
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("M", «Мужской»);
        map.put("F", «Женский»);
        print(map.entrySet());
        printWithForeach(set);
        printWithForeach(list);
        printWithForeach(quene);
        printWithForeach(map.entrySet());
    }
}

```

Если элементы в коллекции не отсортированы, порядок, в котором Итератор перебирает элементы в коллекции, является произвольным и не обязательно совпадает с порядком, в котором элементы добавляются в коллекцию.

Когда объект Iterator получен с помощью метода iterator() коллекции Collection, если текущий поток или другие потоки модифицируют коллекцию с помощью некоторых методов коллекции, тогда доступ к методу next () этого объекта Iterator вызовет java.util. Исключение .ConcurrentModificationException во время выполнения, код выглядит следующим образом
```java

public class ConcurrentTester {
    public static void main(String[] args) {
        // текущий поток
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        
        for (String string : arrayList) {
            if ("e".equals(string)) {
                arrayList.remove(string);
            }
        }

       // Другие темы
        final int size=1000;
        final HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            set.add(new Integer(i));
        }
        // Поток, ответственный за обход коллекции
        Thread reader = new Thread(){
            public void run(){
                for (Integer i : set) {
                    System.out.println(i);// Throw ConcurrentModificationException
                    yield();// Передаем коллекцию другому потоку
                }
        }};
        // Поток, отвечающий за удаление элементов в коллекции
        Thread remover = new Thread(){
            public void run(){
                for (int i = 0; i < size; i++) {
                    set.remove(new Integer(i));// удаляем элементы из коллекции
                    yield();
                }

            }
        };
        reader.start();
        remover.start();
    }
}

```
