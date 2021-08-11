package ua.mycom;

import ua.mycom.*;
import java.util.Scanner; 

public class Exc1 {
    static void subroutine() {
		int d = 0;
		int a = 10 / d;
	}
}

public class Main {
	
	static void procedure() {
		try {
		     int c[] = { 1 };
		     c[42] = 99;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("array index oob: " + e);
		} 
	}

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int[] m = {-1,0,1}; 
	       Scanner sc = new Scanner(System.in); 
	       try { 
	           int a = sc.nextInt();     
	           m[a] = 4/a; 
	           System.out.println(m[a]); 
	       } catch (ArithmeticException e) { 
	           System.out.println("Произошла недопустимая арифметическая операция"); 
	       } catch (ArrayIndexOutOfBoundsException e) { 
	           System.out.println("Обращение по недопустимому индексу массива"); 
	       } 

//		int[] numbers = new int[3];
//		numbers[4]=45;
//		System.out.println(numbers[4]);       
		
		try{
		    int[] numbers = new int[3];
		    numbers[4]=45;
		    System.out.println(numbers[4]);
		}
		catch(Exception ex){
		     
		    ex.printStackTrace();
		}
		finally{
		    System.out.println("Блок finally");
		}
		System.out.println("Программа завершена");
		
//		int d = 0;
//		int a = 42 / d;
		
        try {
            int d = 0;
             int a = 42 / d;
            }

        catch (ArithmeticException e) {
            System.out.println("division by zero");
        }
		
//		Exc1.subroutine();
        
        try {
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 / a;
            int c[] = { 1 };
            c[42] = 99;
       }

       catch (ArithmeticException e) {
           System.out.println("div by 0: " + e);
       }

       catch(ArrayIndexOutOfBoundsException e) {
           System.out.println("array index oob: " + e);
       }
        
       try {
            int len = args.length;
            System.out.println("a = " + len);
            int b = 42 / len;
            procedure();
       }
       catch (ArithmeticException e) {
    	   System.out.println("div by 0: " + e);
       }
       
       
		
	}
}
