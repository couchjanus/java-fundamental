
public class Cat {
	
//	String name;
//	String color;
	
	private String name;
	private String color;
	
	public Cat(String x, String y){
	      name = x;
	      color = y;
	 } 
	 
	public String getName(){
	      return name;
	} 
	 
	public void setName(String a){
	      name=a;
	}
	 
	public String getColor(){
	      return color;
	} 
	 
	public void setColor(String color){
	      this.color = color;
	}
	
	public static void swapFunction(int a, int b) {
	      System.out.println("До замены: a = " + a + " b = " + b);
	      // Передача параметров
	      int c = a;
	      a = b;
	      b = c;
	      System.out.println("После замены: a = " + a + " b = " + b);
	}
	
	public static void printMax(double... numbers) {
	      if (numbers.length == 0) {
	         System.out.println("Ни один аргумент не передается");
	         return;
	      }

	      double result = numbers[0];

	      for (int i = 1; i <  numbers.length; i++)
	      if (numbers[i] >  result)
	      result = numbers[i];
	      System.out.println("Максимальное значение " + result);
	}
}
