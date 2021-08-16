package ua.mycom;

import java.util.*;
import java.util.ArrayList;

import ua.mycom.*;

public class Main {
	
	public static void main(String args[]) {
//	       ArrayList<String> people = new ArrayList<String>();
//	        // добавим в список ряд элементов
//	        people.add("Tom");
//	        people.add("Alice");
//	        people.add("Kate");
//	        people.add("Sam");
//	        people.add(1, "Bob"); // добавляем элемент по индексу 1
//	          
//	        System.out.println(people.get(1));// получаем 2-й объект
//	        people.set(1, "Robert"); // установка нового значения для 2-го объекта
//	          
//	        System.out.printf("ArrayList has %d elements \n", people.size());
//	        for(String person : people){
//	          
//	            System.out.println(person);
//	        }
//	        // проверяем наличие элемента
//	        if(people.contains("Tom")){
//	          
//	            System.out.println("ArrayList contains Tom");
//	        }
//	          
//	        // удалим несколько объектов
//	        // удаление конкретного элемента
//	        people.remove("Robert");
//	        // удаление по индексу
//	        people.remove(0);
//	          
//	        Object[] peopleArray = people.toArray();
//
//	        for(Object person : peopleArray){
//	          
//	            System.out.println(person);
//	        }
// ===============================================        
//	      List a1 = new ArrayList();
//
//	      a1.add("Tom");
//
//	      a1.add("Mark");
//
//	      a1.add("Kate");
//
//	      System.out.println("ArrayList Элементы");
//
//	      System.out.print("\t" + a1);
//
//	      List l1 = new LinkedList();
//
//	      l1.add("Tom");
//
//	      l1.add("Mark");
//
//	      l1.add("Kate");
//
//	      System.out.println();
//
//	      System.out.println("LinkedList Элементы");
//
//	      System.out.print("\t" + l1);

//	      =====================================
	      
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
	 

	 

//	      ===================================
		
//		List<String> states = new ArrayList<String>();
//        
//        states.add("Германия");
//        states.add("Франция");
//        states.add("Италия");
//        states.add("Испания");
//         
//        Iterator<String> iter = states.iterator();
//
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//        }
	      
	      
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
    private static void printCollection(String title, List<MyClass> list) {
        System.out.println(title);
        for(MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
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
