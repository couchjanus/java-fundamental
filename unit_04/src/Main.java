
//class Cat{
//		 
//	 String name;
//	 String color;
//		 
//}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat; // объявление переменной
//		cat = new Cat(); // выделение памяти под объект Cat
		cat = new Cat("Rat", "Red");
		//	Для доступа к объекту необходимо ставить точку и указывать имя переменной или функции

//		cat.name = "Cooma";
//		cat.setName("Coocoo");
//		System.out.println("Cats name is "+cat.name);
		System.out.println("Cats name is "+cat.getName());
		System.out.println("Her color is "+cat.getColor());
		
		cat.swapFunction(7, 8);
		cat.printMax(2.3, 4.5, 6.77);

	}

}
