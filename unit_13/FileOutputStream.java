package ua.mycom;
import java.io.*;

public class Main {
	public static void main(String args[]) {
		// Для создания объекта FileOutputStream используется конструктор, принимающий в качестве параметра путь к файлу для записи. Если такого файла нет, то он автоматически создается при записи. Так как здесь записываем строку, то ее надо сначала перевести в массив байтов. И с помощью метода write строка записывается в файл.

        String text = "Hello world!"; // строка для записи

        // Для автоматического закрытия файла и освобождения ресурса объект FileOutputStream создается с помощью конструктции try...catch.

        try(FileOutputStream fos=new FileOutputStream("C://SomeDir//notes.txt"))
        {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            // При этом необязательно записывать весь массив байтов. Используя перегрузку метода write(), можно записать и одиночный байт:
            // fos.write(buffer[0]); // запись первого байта

            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
              
            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");	        
     }    
}
	