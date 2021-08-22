# Сортировка

## Сортировка элементов

чтобы отсортировать коллекцию элементов, например, массив, нужно по этой коллекции как-то пройти:
```java

int[] array = {10, 2, 10, 3, 1, 2, 5};
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}
```

## сложность алгоритма
Мы имеем цикл, в котором меняем значение индекса (int i) с 0 до последнего элемента в массиве. 
Фактически, мы просто берём каждый элемент в массиве и печатаем его содержимое. Чем больше элементов в массиве, тем дольше будет выполняться код.

То есть, если n — количество элементов, при n=10 программа будет выполняться дольше, чем при n=5, в 2 раза. Когда в программе есть один цикл, время выполнения растёт линейно: чем больше элементов, тем дольше выполнение. В таких случаях говорят, что сложность алгоритма равна O(n). Это обозначение ещё называют большое О или асимптотическое поведение.


## Простейшая сортировка (Bubble Sort)
Попробуем отсортировать массив по возрастанию. Это значит, что имея два элемента (например, a=6, b=5), мы должны переставить местами a и b, если a больше чем b (если a > b).
Это значит, что если элемент с индексом а больше, чем элемент с индексом b, (array[a] > array[b]), такие элементы надо поменять местами.

Перемену мест часто называют swap.
```java

public class Main {

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i-1);
            }
        }
        System.out.println(Arrays.toString(array));
    
    }
}

```

Но наш итоговый массив не отсортирован, т.к. за один проход не удаётся все отсортировать. Придётся добавить ещё цикл, в котором мы будем выполнять проходы один за одним до тех пор, пока не получим отсортированный массив:
```java

public class Main {

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i-1);
                    needIteration = true;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    
    }
    
}

```
Мы итерируемся во внешнем цикле (while) до тех пор, пока не решим, что итераций больше не нужно. По умолчанию перед каждой новой итерацией мы допускаем, что наш массив отсортирован, и больше итерироваться не хотим. Поэтому, мы проходим элементы последовательно и проверяем это допущение. Но если элементы не по порядку, мы выполняем swap элементов и понимаем, что нет уверенности, что теперь элементы в правильном порядке. Следовательно, хотим выполнить ещё одну итерацию. Например, [3, 5, 2]. 5 больше трёх, всё хорошо. Но 2 меньше 5. Однако [3, 2, 5] требует ещё одного прохода, т.к. 3 > 2 и их нужно поменять местами.

При n элементах сложность алгоритма становится n * n, то есть O(n^2). Такая сложность называется квадратичной. 

Сортировка пузырьком — одна из самых простых и неэффективных сортировок. Её ещё иногда называют "глупой сортировкой".


## Сортировка выбором (Selection Sort)
Сортировка выбором имеет квадратичную сложность.

Каждый проход выбирать самый минимальный элемент и смещать его в начало. При этом каждый новый проход начинать сдвигаясь вправо, то есть первый проход — с первого элемента, второй проход — со второго. 
```java
public class Main {

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
        System.out.println(Arrays.toString(array));

    
    }
    
}
```
Данная сортировка неустойчива, т.к. одинаковые элементы могут изменить своё положение.


## Сортировка вставками (Insertion Sort)
Сортировка вставками тоже имеет квадратичную сложность, так как у нас опять цикл в цикле. Данная сортировка является устойчивой. Это значит, что одинаковые элементы не изменят свой порядок.
```java
public class Main {

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
        System.out.println(Arrays.toString(array));
    
    }
    
}

```

## Челночная сортировка (Shuttle Sort)

Суть алгоритма в том, что мы итерируемся слева направо, при этом при выполнении swap элементов мы выполняем проверку всех остальных элементов, которые остались позади, не нужно ли повторить swap.
```java

public class Main {

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    
    }
    
}

```

## Сортировка Шелла
Суть её похожа на сортировку пузырьком, но каждую итерацию мы имеем разный промежуток между сравниваемыми элементами. Каждую итерацию он уменьшается вдвое. 
```java

public class Main {

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        // Высчитываем промежуток между проверяемыми элементами
        int gap = array.length / 2;
        // Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
               for (int c = right - gap; c >= 0; c -= gap) {
                   if (array[c] > array[c + gap]) {
                       swap(array, c, c + gap);
                   }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
        System.out.println(Arrays.toString(array));
    
    }
    
}

```    
## Cортировка слиянием (merge sort)
Сложность данного алгоритма — логарифмическая. Записывается как O(n log n).

Сначала, напишем рекурсивный вызов метода сортировки:
```java

public class Main {
   
    public static void mergeSort(int[] source, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // вычисляем delimiter — положение делителя. Если делитель может разделить на 2 части, значит вызываем рекурсивно сортировку для участков, на которые делитель разбил массив. 

        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        // Создаём временный массив с нужным размером
        // Подготавливаем дополнительный буферный массив, в котором выделяем отсортированный участок. 
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        // устанавливаем курсор в начало сортируемого участка и начинаем идти по каждому элементу пустого массива и заполняем его наименьшими элементами. 
        // Если элемент, на который указывает курсор меньше, чем элемент, на который указывает делитель — помещаем в буферный массив этот элемент и сдвигаем курсор. В противном случае помещаем в буферный массив элемент, на который указывает разделитель и сдвигаем разделитель. 


        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        // Как только разделитель уйдёт за границы сортируемого участка или мы заполним весь массив, указанный диапазон считается отсортированным.
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }

    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        // Принимаем на вход массив с указанием начала и конца участка для сортировки. При начале сортировки — это начало и конец массива. 
        mergeSort(array, 0, array.length-1);
    
        System.out.println(Arrays.toString(array));
    
    }
    
}

```

## Сортировка подсчётом (Counting Sort) 
Алгоритмическая сложность Counting Sort будет O(n+k), где n — количество элементов, а k — максимальное значение элемента. нам нужно знать минимальное и максимальное значение в массиве.
```java

public class Main {

    public static int[] countingSort(int[] theArray, int maxValue) {
        // Массив со "счётчиками" размером от 0 до максимального значения
        int numCounts[] = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // идём по массиву со "счётчиками"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
    
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
    
        System.out.println(Arrays.toString(countingSort(array, 10)));
    
    }
    
}

```

## Быстрая сортировка (Quick Sort)
Она имеет алгоритмическую сложность, то есть мы имеем O(n log n).
Данную сортировку ещё называют сортировкой Хоара. 
```java

public class Main {

public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }   
    public static void main(String args[]) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        quickSort(array, 0, 6);
        System.out.println(Arrays.toString(array));
    
    }
    
}

```
Для входного массива int[] source выставляем два маркера, левый (L) и правый (R). При первом вызове они соответствуют началу и концу массива.

Далее определяется опорный элемент, он же pivot. После этого наша задача — переместить значения, меньшие чем pivot, в левую от pivot часть, а большие — в правую. 

Для этого сначала двигаем указатель L, пока не найдём значение, большее чем pivot. Если меньше значения не нашли, то L совпадёт с pivot. 

Потом двигаем указатель R пока не найдём меньшее, чем pivot значение. Если меньшее значение не нашли, то R совпадёт с pivot.
 
Далее, если указатель L находится до указателя R или совпадает с ним, то пытаемся выполнить обмен элементов, если элемент L меньше, чем R.
 
Далее L сдвигаем вправо на 1 позицию, R сдвигаем влево на одну позицию. 

Когда левый маркер L окажется за правым маркером R это будет означать, что обмен закончен, слева от pivot меньшие значения, справа от pivot — большие значения.

После этого рекурсивно вызываем такую же сортировку для участков массива от начала сортируемого участка до правого маркера и от левого маркера до конца сортируемого участка.

Почему от начала до правого? Потому что в конце итерации так и получится, что правый маркер сдвинется настолько, что станет границей части слева.

Этот алгоритм более сложный, чем простая сортировка, поэтому его лучше зарисовать. Возьмём белый лист бумаги, запишем: 4 2 6 7 3 , а Pivot по центру, т.е. число 6. Обведём его в круг. 

Под 4 напишем L, под 3 напишем R. 4 меньше чем 6, 2 меньше чем 6. Итого, L переместился на положение pivot, т.к. по условию L не может уйти дальше, чем pivot. 

Напишем снова 4 2 6 7 3 , обведём 6 вкруг (pivot) и поставим под ним L. Теперь двигаем указатель R. 

3 меньше чем 6, поэтому ставим маркер R на цифру 3. Так как 3 меньше, чем pivot 6 выполняем swap, т.е. обмен. 

Запишем результат: 4 2 3 7 6 , обводим 6 вкруг, т.к. он по прежнему pivot.

Указатель L на цифре 3, указатель R на цифре 6. Мы помним, что двигаем указатели до тех пор, пока L не зайдём за R. L двигаем на следующую цифру.

Тут хочется разобрать два варианта: если бы предпоследняя цифра была 7 и если бы она была не 7, а 1. 

Предпоследня цифра 1: Сдвинули указатель L на цифру 1, т.к. мы можем двигать L до тех пор, пока указатель L указывает на цифру, меньшую чем pivot. А вот R мы не можем сдвинуть с 6, т.к. R не мы можем двигать только если указатель R указывает на цифру, которая больше чем pivot. swap не делаем, т.к. 1 меньше 6. Записываем положение: 4 2 3 1 6, обводим pivot 6. L сдвигается на pivot и больше не двигается. R тоже не двигается. Обмен не производим. Сдвигаем L и R на одну позицию и подписываем цифру 1 маркером R, а L получается вне числа. Т.к. L вне числа — ничего не делаем, а вот часть 4 2 3 1 выписываем снова, т.к. это наша левая часть, меньшая, чем pivot 6. Выделяем новый pivot и начинаем всё снова )

Предпоследняя цифра 7: Сдвинули указать L на цифру 7, правый указатель не можем двигать, т.к. он уже указывает на pivot. т.к. 7 больше, чем pivot, то делаем swap. Запишем результат: 4 2 3 6 7, обводим 6 кружком, т.к. он pivot. Указатель L теперь сдвигается на цифру 7, а указатель R сдвигается на цифру 3. Часть от L до конца нет смысла сортировать, т.к. там всего 1 элемент, а вот часть от 4 до указателя R отправляем на сортировку. Выбираем pivot и начинаем всё снова )

Единственный минус — такая сортировка не является стабильной. Т.к. при выполнении обмена одинаковые элементы могут поменять свой порядок, если один из них встретился до pivot до того, как другой элемент попал в часть до pivot при помощи обмена.

## Интерфейс Set

Интерфейс Set расширяет интерфейс Collection и представляет набор уникальных элементов. Set не добавляет новых методов, только вносит изменения унаследованные. В частности, метод add() добавляет элемент в коллекцию и возвращает true, если в коллекции еще нет такого элемента.
 
Интерфейс Set — это Collection, который не может содержать повторяющиеся элементы. Он моделирует математическую установку абстракции.

Методы
- add() Добавляет объект к коллекции.
- clear() Удаляет все объекты из коллекции.
- contains() Возвращает true, если указанный объект является элементом в коллекции.
- isEmpty() Возвращает true, если в коллекции нет элементов.
- iterator() Возвращает объект Iterator, который может быть использован для извлечения объекта
- remove( ) Удаляет указанный объект из коллекции.
- size( ) Возвращает число элементов в коллекции.

В Java интерфейс Set имеет свою реализацию в различных классах как HashSet, TreeSet, LinkedHashSet. 

### Set:

```java
package ua.mycom;

import java.util.*;
import java.util.ArrayList;

import ua.mycom.*;

public class Main {
    
    public static void main(String args[]) {
        int count[] = {34, 22,10,60,30,22};

        Set set = new HashSet();
        try {
            for(int i = 0; i < 5; i++) {
                set.add(count[i]);
            }

            System.out.println(set);
            TreeSet sortedSet = new TreeSet(set);
            System.out.println("Отсортированный список:");
            System.out.println(sortedSet);
            System.out.println("Первый элемент набора: "+ (Integer)sortedSet.first());
            System.out.println("Последний элемент набора: "+ (Integer)sortedSet.last());
        }
        catch(Exception e) {}
    }

}

```
## Обобщенный класс HashSet
 
Обобщенный класс HashSet представляет хеш-таблицу. Он наследует свой функционал от класса AbstractSet, а также реализует интерфейс Set.

Хеш-таблица представляет такую структуру данных, в которой все объекты имеют уникальный ключ или хеш-код. Данный ключ позволяет уникально идентифицировать объект в таблице.

Для создания объекта HashSet можно воспользоваться одним из следующих конструкторов:
- HashSet(): создает пустой список
- HashSet(Collection<? extends E> col): создает хеш-таблицу, в которую добавляет все элементы коллекции col
- HashSet(int capacity): параметр capacity указывает начальную емкость таблицы, которая по умолчанию равна 16
- HashSet(int capacity, float koef): параметр koef или коэффициент заполнения, значение которого должно быть в пределах от 0.0 до 1.0, указывает, насколько должна быть заполнена емкость объектами прежде чем произойдет ее расширение. Например, коэффициент 0.75 указывает, что при заполнении емкости на 3/4 произойдет ее расширение.

Класс HashSet не добавляет новых методов, реализуя лишь те, что объявлены в родительских классах и применяемых интерфейсах:
```java
package ua.mycom;

import java.util.*;

import ua.mycom.*;

public class Main {
    
    public static void main(String args[]) {
        HashSet<String> states = new HashSet<String>();
        
        // добавим в список ряд элементов
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Кот-Д'Ивуар"); // любимая страна всех котов

        // пытаемся добавить элемент, который уже есть в коллекции
        states.add("Кот-Д'Ивуар"); // любимая страна всех котов
        
        boolean isAdded = states.add("Germany");
        System.out.println(isAdded);    // false
        
        // Получим размер HashSet
        System.out.printf("Set contains %d elements \n", states.size());    // 3
          
        for(String state : states){
          
            System.out.println(state);
        }
        // удаление элемента
        states.remove("Germany");

        // Конвертируем HashSet в массив
        String[] myArray = {};
        myArray = states.toArray(new String[states.size()]);

        for(String p : myArray){
            System.out.println(p);
        }   

        
        // метод iterator() позволяет получить всё множество элементов:
        Iterator<String> iterator = states.iterator();
        
        // порядок добавления стран во множество будет непредсказуемым. HashSet использует хэширование для ускорения выборки. Если вам нужно, чтобы результат был отсортирован, то пользуйтесь TreeSet.

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Random random = new Random(30);
        Set<Integer> numberSet = new HashSet<>();

        for(int i = 0; i < 1000; i++)
            numberSet.add(random.nextInt(10));
        
        System.out.println(numberSet.toString());

        // хеш-таблица объектов Person
        HashSet<Person> people = new HashSet<Person>();
        people.add(new Person("Mike"));
        people.add(new Person("Tom"));
        people.add(new Person("Nick"));
        
        for(Person p : people){
            System.out.println(p.getName());
        }   

        // Конвертируем HashSet в массив
        String[] myArray = {};
        myArray = people.toArray(new String[people.size()]);

        for(String p : myArray){
            System.out.println(p.getName());
        }   

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
## Интерфейс SortedSet

Интерфейс SortedSet предназначен для создания коллекций, который хранят элементы в отсортированном виде (сортировка по возрастанию). SortedSet расширяет интерфейс Set, поэтому такая коллекция хранит только уникальные значения. SortedSet предоставляет следующие методы:
- E first(): возвращает первый элемент набора
- E last(): возвращает последний элемент набора
- SortedSet<E> headSet(E end): возвращает объект SortedSet, который содержит все элементы первичного набора до элемента end
- SortedSet<E> subSet(E start, E end): возвращает объект SortedSet, который содержит все элементы первичного набора между элементами start и end
- SortedSet<E> tailSet(E start): возвращает объект SortedSet, который содержит все элементы первичного набора, начиная с элемента start

Несколько методов вызывают исключение NoSuchElementException, если в вызывающем наборе не содержится элементов. ClassCastException вызывается, когда объект несовместим с элементами в наборе.

Исключение NullPointerException выдается, если совершается попытка использовать нулевой объект и null не допускается в наборе.

SortedSet имеет свою реализацию в различных классах, таких как TreeSet. 

### пример класса TreeSet:

```java
package ua.mycom;

import java.util.*;
import java.util.ArrayList;

import ua.mycom.*;

public class Main {
    
    public static void main(String args[]) {
          // Создаем отсортированный набор
          SortedSet set = new TreeSet(); 

          // Добавляем элементы к наборы
          set.add("b");
          set.add("c");
          set.add("a");

          // Итерация по элементам в наборе
          Iterator it = set.iterator();

          while (it.hasNext()) {
             // Получаем элемент
             Object element = it.next();
             System.out.println(element.toString());
          } 
    }
}

```
## NavigableSet
Интерфейс NavigableSet расширяет интерфейс SortedSet и позволяет извлекать элементы на основании их значений. NavigableSet определяет следующие методы:

- E ceiling(E obj): ищет в наборе наименьший элемент e, который больше obj (e >=obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E floor(E obj): ищет в наборе наибольший элемент e, который меньше элемента obj (e <=obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E higher(E obj): ищет в наборе наименьший элемент e, который больше элемента obj (e >obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E lower(E obj): ищет в наборе наибольший элемент e, который меньше элемента obj (e < obj). Если такой элемент найден, то он возвращается в качестве результата. Иначе возвращается null.
- E pollFirst(): возвращает первый элемент и удаляет его из набора
- E pollLast(): возвращает последний элемент и удаляет его из набора
- NavigableSet<E> descendingSet(): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet в обратном порядке
- NavigableSet<E> headSet(E upperBound, boolean incl): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet до upperBound. Параметр incl при значении true, позволяет включить в выходной набор элемент upperBound
- NavigableSet<E> tailSet(E lowerBound, boolean incl): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet, начиная с lowerBound. Параметр incl при значении true, позволяет включить в выходной набор элемент lowerBound
- NavigableSet<E> subSet(E lowerBound, boolean lowerIncl, E upperBound, boolean highIncl): возвращает объект NavigableSet, который содержит все элементы первичного набора NavigableSet от lowerBound до upperBound.


## TreeSet
Обобщенный класс TreeSet<E> представляет структуру данных в виде дерева, в котором все объекты хранятся в отсортированном виде по возрастанию. TreeSet является наследником класса AbstractSet и реализует интерфейс NavigableSet, а следовательно, и интерфейс SortedSet.

В классе TreeSet определены следующие конструкторы:
- TreeSet(): создает пустое дерево
- TreeSet(Collection<? extends E> col): создает дерево, в которое добавляет все элементы коллекции col
- TreeSet(SortedSet <E> set): создает дерево, в которое добавляет все элементы сортированного набора set
- TreeSet(Comparator<? super E> comparator): создает пустое дерево, где все добавляемые элементы впоследствии будут отсортированы компаратором.

TreeSet поддерживает все стандартные методы для вставки и удаления элементов:

```java
package ua.mycom;

import java.util.*;
import java.util.ArrayList;

import ua.mycom.*;

public class Main {
    
    public static void main(String args[]) {
        TreeSet<String> states = new TreeSet<String>();
        
        // добавим в список ряд элементов
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Great Britain");
        
        System.out.printf("TreeSet contains %d elements \n", states.size());
         
        // удаление элемента
        states.remove("Germany");
        for(String state : states){
          
            System.out.println(state);
        }   
    }
}
// поскольку при вставке объекты сразу же сортируются по возрастанию, 
// то при выводе в цикле for мы получим отсортированный набор:

// TreeSet contains 4 elements
// France
// Great Britain
// Italy

```

Так как TreeSet реализует интерфейс NavigableSet, а через него и SortedSet, то мы можем применить к структуре дерева различные методы:


```java
package ua.mycom;

import java.util.*;
import java.util.ArrayList;

import ua.mycom.*;

public class Main {
    
    public static void main(String args[]) {
        TreeSet<String> states = new TreeSet<String>();
        
        // добавим в список ряд элементов
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");
        states.add("Great Britain");
        
        System.out.println(states.first()); // получим первый - самый меньший элемент
        System.out.println(states.last()); // получим последний - самый больший элемент
        // получим поднабор от одного элемента до другого
        SortedSet<String> set = states.subSet("Germany", "Italy");
        System.out.println(set);
        // элемент из набора, который больше текущего
        String greater = states.higher("Germany");
        // элемент из набора, который меньше текущего
        String lower = states.lower("Germany");
        // возвращаем набор в обратном порядке
        NavigableSet<String> navSet = states.descendingSet();
        // возвращаем набор в котором все элементы меньше текущего
        SortedSet<String> setLower=states.headSet("Germany");
        // возвращаем набор в котором все элементы больше текущего
        SortedSet<String> setGreater=states.tailSet("Germany");  
        System.out.println(navSet);
        System.out.println(setLower);
        System.out.println(setGreater);
    }
}

```

## Интерфейсы Comparable и Comparator. 
 
При добавлении новых элементов объект TreeSet автоматически проводит сортировку, помещая новый объект на правильное для него место. 

А что если бы мы использовали не строки, а свои классы, например, следующий класс Person:

```java
class Person{
    
    private String name;
    Person(String name){
          
        this.name=name;
    }
    String getName(){return name;}
}

// Объект TreeSet мы не сможем типизировать данным классом, поскольку в случае добавления объектов TreeSet не будет знать, как их сравнивать, и следующий кусок кода не будет работать:

TreeSet<Person> people = new TreeSet<Person>();
people.add(new Person("Tom"));

// При выполнении этого кода мы столкнемся с ошибкой, которая скажет, что объект Person не может быть преобразован к типу java.lang.Comparable.

```
## Интерфейс Comparable
Для того, чтобы объекты Person можно было сравнить и сортировать, они должны применять интерфейс Comparable<E>. При применении интерфейса он типизируется текущим классом. Применим его к классу Person:

```java
class Person implements Comparable<Person>{
    
    private String name;
    Person(String name){
         
        this.name = name;
    }
    String getName(){return name;}
     
    public int compareTo(Person p){
     
        return name.compareTo(p.getName());
    }
}

```
Интерфейс Comparable содержит один единственный метод int compareTo(E item), который сравнивает текущий объект с объектом, переданным в качестве параметра. Если этот метод возвращает отрицательное число, то текущий объект будет располагаться перед тем, который передается через параметр. Если метод вернет положительное число, то, наоборот, после второго объекта. Если метод возвратит ноль, значит, оба объекта равны.

В данном случае мы не возвращаем явным образом никакое число, а полагаемся на встроенный механизм сравнения, который есть у класса String. Но мы также можем определить и свою логику, например, сравнивать по длине имени:
```java

public int compareTo(Person p){
     
    return name.length()-p.getName().length();
}

```
Теперь мы можем типизировать TreeSet типом Person и добавлять в дерево соответствующие объекты:
```java

TreeSet<Person> people = new TreeSet<Person>();
people.add(new Person("Tom"));

```
## Интерфейс Comparator
Однако перед нами может возникнуть проблема, что если разработчик не реализовал в своем классе, который мы хотим использовать, интерфейс Comparable, либо реализовал, но нас не устраивает его функциональность, и мы хотим ее переопределить? На этот случай есть еще более гибкий способ, предполагающий применение интерфейса Comparator<E>.

Интерфейс Comparator содержит ряд методов, ключевым из которых является метод compare():
```java

public interface Comparator<E> {
 
    int compare(T a, T b);
    // остальные методы
}

```
Метод compare также возвращает числовое значение - если оно отрицательное, то объект a предшествует объекту b, иначе - наоборот. А если метод возвращает ноль, то объекты равны. Для применения интерфейса нам вначале надо создать класс компаратора, который реализует этот интерфейс:
```java

class PersonComparator implements Comparator<Person>{
 
    public int compare(Person a, Person b){
     
        return a.getName().compareTo(b.getName());
    }
}

```
### проводим сравнение по строкам. 

Теперь используем класс компаратора для создания объекта TreeSet:

```java
package ua.mycom;

import java.util.*;
import java.util.ArrayList;

import ua.mycom.*;

public class Main {
    
    public static void main(String args[]) {
        PersonComparator pcomp = new PersonComparator();

        TreeSet<Person> people = new TreeSet<Person>(pcomp);
        people.add(new Person("Tom"));
        people.add(new Person("Nick"));
        people.add(new Person("Alice"));
        people.add(new Person("Bill"));
        for(Person  p : people){
            System.out.println(p.getName());
        }    
    }
}

class PersonComparator implements Comparator<Person>{
     
    public int compare(Person a, Person b){
     
        return a.getName().compareTo(b.getName());
    }
}


```
Для создания TreeSet здесь используется одна из версий конструктора, которая в качестве параметра принимает компаратор. Теперь вне зависимости от того, реализован ли в классе Person интерфейс Comparable, логика сравнения и сортировки будет использоваться та, которая определена в классе компаратора.

## Сортировка по нескольким критериям
Начиная с JDK 8 в механизм работы компараторов были внесены некоторые дополнения. В частности, теперь мы можем применять сразу несколько компараторов по принципу приоритета. Например, изменим класс Person следующим образом:

```java
package ua.mycom;

class Person{
    
    private String name;
    private int age;
    public Person(String n, int a){
          
        name=n;
        age=a;
    }
    String getName(){return name;}
    int getAge(){return age;}
}

```
Здесь добавлено поле для хранения возраста пользователя. И, допустим, нам надо отсортировать пользователей по имени и по возрасту. Для этого определим два компаратора:

```java
package ua.mycom;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        
        // Интерфейс компаратора определяет специальный метод по умолчанию thenComparing, 
        // который позволяет использовать цепочки компараторов для сортировки набора:

        Comparator<Person> pcomp = new PersonNameComparator().thenComparing(new PersonAgeComparator());
        TreeSet<Person> people = new TreeSet(pcomp);

        people.add(new Person("Tom", 23));
        people.add(new Person("Nick",34));
        people.add(new Person("Tom",10));
        people.add(new Person("Bill",14));
         
        for(Person  p : people){
         
            System.out.println(p.getName() + " " + p.getAge());
        }
    
    }
}

class PersonNameComparator implements Comparator<Person>{
      
    public int compare(Person a, Person b){
      
        return a.getName().compareTo(b.getName());
    }
}
class PersonAgeComparator implements Comparator<Person>{
  
    public int compare(Person a, Person b){
      
        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}

// Консольный вывод:

// Bill 14
// Nick 34
// Tom 10
// Tom 23
// В данном случае сначала применяется сортировка по имени, а потом по возрасту.

```

## Интерфейс Map и класс HashMap
 
Интерфейс Map<K, V> представляет отображение или иначе говоря словарь, где каждый элемент представляет пару "ключ-значение". При этом все ключи уникальные в рамках объекта Map. Такие коллекции облегчают поиск элемента, если нам известен ключ - уникальный идентификатор объекта.

в отличие от других интерфейсов, которые представляют коллекции, интерфейс Map НЕ расширяет интерфейс Collection.

Среди методов интерфейса Map можно выделить следующие:
- void clear(): очищает коллекцию
- boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
- boolean containsValue(Object v): возвращает true, если коллекция содержит значение v
- Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
- boolean equals(Object obj): возвращает true, если коллекция идентична коллекции, передаваемой через параметр obj
- boolean isEmpty: возвращает true, если коллекция пуста
- V get(Object k): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение null
- V getOrDefault(Object k, V defaultValue): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение defaultVlue
- V put(K k, V v): помещает в коллекцию новый объект с ключом k и значением v. Если в коллекции уже есть объект с подобным ключом, то он перезаписывается. После добавления возвращает предыдущее значение для ключа k, если он уже был в коллекции. Если же ключа еще не было в коллекции, то возвращается значение null
- V putIfAbsent(K k, V v): помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента с подобным ключом.
- Set<K> keySet(): возвращает набор всех ключей отображения
- Collection<V> values(): возвращает набор всех значений отображения
- void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
- V remove(Object k): удаляет объект с ключом k
- int size(): возвращает количество элементов коллекции

Чтобы положить объект в коллекцию, используется метод put, а чтобы получить по ключу - метод get. Реализация интерфейса Map также позволяет получить наборы как ключей, так и значений. А метод entrySet() возвращает набор всех элементов в виде объектов Map.Entry<K, V>.


Map имеет своё реализацию в различных классах, таких как HashMap. 

```java
package ua.mycom;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
          Map m1 = new HashMap(); 
          m1.put("Маша", "8");
          m1.put("Михаил", "31");
          m1.put("Олег", "12");
          m1.put("Денис", "14");

          System.out.println();
          System.out.println("Элементы карты");
          System.out.print("\t" + m1);    
    }
}

```

## Интерфейс Map.Entry

Обобщенный интерфейс Map.Entry<K, V> представляет объект с ключом типа K и значением типа V и определяет следующие методы:

- boolean equals(Object obj): возвращает true, если объект obj, представляющий интерфейс Map.Entry, идентичен текущему
- K getKey(): возвращает ключ объекта отображения
- V getValue(): возвращает значение объекта отображения
- V setValue(V v): устанавливает для текущего объекта значение v
- int hashCode(): возвращает хеш-код данного объекта

Интерфейс Map.Entry позволяет работать с записями Map.

Метод entrySet(), объявленный интерфейсом Map, возвращает Set, содержащий записи Map. Каждый из этих элементов является объектом Map.Entry.

### как можно использовать Map.Entry:

```java
package ua.mycom;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
          // Создаём хэш-карту
          HashMap hm = new HashMap();

          // Кладём элементы в Map
          hm.put("Зоя", new Double(3434.34));
          hm.put("Марк", new Double(123.22));
          hm.put("Аня", new Double(1378.00));
          hm.put("Маргарита", new Double(99.22));
          hm.put("Михаил", new Double(-19.08));
          
          // Получаем набор элементов
          Set set = hm.entrySet();
          
          // Получаем итератор
          Iterator i = set.iterator();
         
          // Отображение элементов
          while(i.hasNext()) {
             Map.Entry me = (Map.Entry)i.next();
             System.out.print(me.getKey() + ": ");
             System.out.println(me.getValue());
          }
          System.out.println();
         
          // Вносим 1000 на счёт Зои
          double balance = ((Double)hm.get("Зоя")).doubleValue();
          hm.put("Зоя", new Double(balance + 1000));
          System.out.println("Новый баланс Зои: " + hm.get("Зоя"));    
    }
}

```

## Классы отображений. HashMap
Базовым классом для всех отображений является абстрактный класс AbstractMap, который реализует большую часть методов интерфейса Map. Наиболее распространенным классом отображений является HashMap, который реализует интерфейс Map и наследуется от класса AbstractMap.

```java

package ua.mycom;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        Map<Integer, String> states = new HashMap<Integer, String>();
       states.put(1, "Germany");
       states.put(2, "Spain");
       states.put(4, "France");
       states.put(3, "Italy");
         
       // получим объект по ключу 2
       String first = states.get(2);
       System.out.println(first);
       // получим весь набор ключей
       Set<Integer> keys = states.keySet();
       // получить набор всех значений
       Collection<String> values = states.values();
       //заменить элемент
       states.replace(1, "Poland");
       // удаление элемента по ключу 2
       states.remove(2);
       // перебор элементов
       for(Map.Entry<Integer, String> item : states.entrySet()){
         
           System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
       }
          
       Map<String, Person> people = new HashMap<String, Person>();
       people.put("1240i54", new Person("Tom"));
       people.put("1564i55", new Person("Bill"));
       people.put("4540i56", new Person("Nick"));
         
       for(Map.Entry<String, Person> item : people.entrySet()){
         
           System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
       }    
    }
}

public class Person {

    private String name;
    public Person(String value){
          
        name=value;
    }
    String getName(){return name;}
}

```
Чтобы добавить или заменить элемент, используется метод put, либо replace, а чтобы получить его значение по ключу - метод get. С помощью других методов интерфейса Map также производятся другие манипуляции над элементами: перебор, получение ключей, значений, удаление.
 
Для создания отображений Java также предоставляет ряд дополнительных интерфейсов: SortedMap и NavigableMap

## SortedMap
Интерфейс SortedMap расширяет Map и создает отображение, в котором все элементы отсортированы в порядке возрастания их ключей. SortedMap добавляет ряд методов:
- K firstKey(): возвращает ключ первого элемента отображения
- K lastKey(): возвращает ключ последнего элемента отображения
- SortedMap<K, V> headMap(K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap вплоть до элемента с ключом end
- SortedMap<K, V> tailMap(K start): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap, начиная с элемента с ключом start
- SortedMap<K, V> subMap(K start, K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap вплоть от элемента с ключом start до элемента с ключом end
- SortedMap имеет свою реализацию в различных классах, например TreeMap. Ниже приведен пример объяснения функциональности SortedMap:

```java
package ua.mycom;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
          // Создаём хэш-карту
          TreeMap tm = new TreeMap();
          
          // Кладём элементы в Map
          tm.put("Зоя", new Double(3434.34));
          tm.put("Марк", new Double(123.22));
          tm.put("Аня", new Double(1378.00));
          tm.put("Маргарита", new Double(99.22));
          tm.put("Михаил", new Double(-19.08));
          
          // Получаем набор элементов
          Set set = tm.entrySet();
          
          // Получаем итератор
          Iterator i = set.iterator();
          
          // Отображение элементов
          while(i.hasNext()) {
             Map.Entry me = (Map.Entry)i.next();
             System.out.print(me.getKey() + ": ");
             System.out.println(me.getValue());
          }
          System.out.println();
          
          // Вносим 1000 на счёт Зои
          double balance = ((Double)tm.get("Зоя")).doubleValue();
          tm.put("Зоя", new Double(balance + 1000));
          System.out.println("Новый баланс Зои: " + tm.get("Зоя"));    
    }
}

```

## NavigableMap
Интерфейс NavigableMap расширяет интерфейс SortedMap и обеспечивает возможность получения элементов отображения относительно других элементов. Его основные методы:

- Map.Entry<K, V> ceilingEntry(K obj): возвращает элемент с наименьшим ключом k, который больше или равен ключу obj (k >=obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> floorEntry(K obj): возвращает элемент с наибольшим ключом k, который меньше или равен ключу obj (k <=obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> higherEntry(): возвращает элемент с наименьшим ключом k, который больше ключа obj (k >obj). Если такого ключа нет, то возвращается null.
- Map.Entry<K, V> lowerEntry(): возвращает элемент с наибольшим ключом k, который меньше ключа obj (k < obj). Если такого ключа нет, то возвращается null.
- Map.Entry < K, V> firstEntry(): возвращает первый элемент отображения
- Map.Entry<K, V> lastEntry(): возвращает последний элемент отображения
- Map.Entry<K, V> pollFirstEntry(): возвращает и одновременно удаляет первый элемент из отображения
- Map.Entry<K, V> pollLastEntry(): возвращает и одновременно удаляет последний элемент из отображения
- K ceilingKey(K obj): возвращает наименьший ключ k, который больше или равен ключу obj (k >=obj). Если такого ключа нет, то возвращается null.
- K floorKey(K obj): возвращает наибольший ключ k, который меньше или равен ключу obj (k <=obj). Если такого ключа нет, то возвращается null.
- K lowerKey(K obj): возвращает наибольший ключ k, который меньше ключа obj (k < obj). Если такого ключа нет, то возвращается null.
- K higherKey(K obj): возвращает наименьший ключ k, который больше ключа obj (k >obj). Если такого ключа нет, то возвращается null.
- NavigableSet<K> descendingKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения в обратном порядке
- NavigableMap<K, V> descendingMap(): возвращает отображение NavigableMap, которое содержит все элементы в обратном порядке
- NavigableSet<K> navigableKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения
- NavigableMap<K, V> headMap(K upperBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap вплоть от элемента с ключом upperBound. Параметр incl при значении true указывает, что элемент с ключом upperBound также включается в выходной набор.
- NavigableMap<K, V> tailMap(K lowerBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap, начиная с элемента с ключом lowerBound. Параметр incl при значении true указывает, что элемент с ключом lowerBound также включается в выходной набор.
- NavigableMap<K, V> subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl): возвращает отображение NavigableMap, которое содержит все элементы оригинального NavigableMap от элемента с ключом lowerBound до элемента с ключом upperBound. Параметры lowIncl и highIncl при значении true включают в выходной набор элементы с ключами lowerBound и upperBound соответственно.

## TreeMap
Класс TreeMap<K, V> представляет отображение в виде дерева. Он наследуется от класса AbstractMap и реализует интерфейс NavigableMap, а следовательно, также и интерфейс SortedMap. Поэтому в отличие от коллекции HashMap в TreeMap все объекты автоматически сортируются по возрастанию их ключей.

Класс TreeMap имеет следующие конструкторы:
- TreeMap(): создает пустое отображение в виде дерева
- TreeMap(Map<? extends K,? extends V> map): создает дерево, в которое добавляет все элементы из отображения map
- TreeMap(SortedMap<K, ? extends V> smap): создает дерево, в которое добавляет все элементы из отображения smap
- TreeMap(Comparator<? super K> comparator): создает пустое дерево, где все добавляемые элементы впоследствии будут отсортированы компаратором.

```java

package ua.mycom;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        TreeMap<Integer, String> states = new TreeMap<Integer, String>();
           states.put(10, "Germany");
           states.put(2, "Spain");
           states.put(14, "France");
           states.put(3, "Italy");
             
           // получим объект по ключу 2
           String first = states.get(2);
           // перебор элементов
           for(Map.Entry<Integer, String> item : states.entrySet()){
             
               System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
           }
           // получим весь набор ключей
           Set<Integer> keys = states.keySet();
           // получить набор всех значений
           Collection<String> values = states.values();
             
           // получаем все объекты, которые стоят после объекта с ключом 4
           Map<Integer, String> afterMap = states.tailMap(4);
             
           // получаем все объекты, которые стоят до объекта с ключом 10
           Map<Integer, String> beforeMap = states.headMap(10);
             
           // получим последний элемент дерева
           Map.Entry<Integer, String> lastItem = states.lastEntry();
             
           System.out.printf("Last item has key %d value %s \n",lastItem.getKey(), lastItem.getValue());
              
           Map<String, Person> people = new TreeMap<String, Person>();
           people.put("1240i54", new Person("Tom"));
           people.put("1564i55", new Person("Bill"));
           people.put("4540i56", new Person("Nick"));
             
           for(Map.Entry<String, Person> item : people.entrySet()){
             
               System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
           }    
    }
}

class Person{
      
    private String name;
    public Person(String name){
          
        this.name = name;
    }
    String getName(){return name;}
}

```
Кроме методов интерфейса Map класс TreeMap реализует методы интерфейса NavigableMap. Например, мы можем получить все объекты до или после определенного ключа с помощью методов headMap и tailMap. Также мы можем получить первый и последний элементы и провести ряд дополнительных манипуляций с объектами.
