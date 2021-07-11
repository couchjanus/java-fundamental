
abstract class AnonymousInner {
   public abstract void mymethod();
}

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();
        System.out.println(innerObject.getNum());
        outerObject.test();
        
        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        Top topLevelObject = new Top();        
        topLevelObject.accessMembers(outerObject);          
        
        Client client = new Client("Jhon doe", "ABC", 111);
        System.out.println("\n Вызываем display, используя ссылку Client --");
        client.display();
        
        Salary s = new Salary ("Mary Ann", "London, UK", 3, 3600.00);
        Employee e = new Salary ("Tom Cat", "NVC, USA", 2, 9400.00);
        System.out.println("Вызываем mailCheck, используя ссылку Salary --");
        s.mailCheck();
        System.out.println("\n Вызываем mailCheck, используя ссылку Employee --");
        e.mailCheck();
        
        
     // Figures figure = new Figures(10, 10); // так нельзя
        Triangle triangle = new Triangle(10, 8);

        Figures figure; // так можно, так как объект мы не создаем
        figure = triangle;
        System.out.println("Площадь равна " + figure.area());
        
        Rect rect = new Rect(10, 10);
        
        System.out.println("Площадь равна " + rect.area());
        System.out.println("Площадь равна " + rect.perimeter());
        

        Object sam = new Employe("Sam", "Oracle");
        Object kate = new Client("Kate", "DeutscheBank", 2000);
        Person bob = new Client("Bob", "DeutscheBank", 3000);
        Person alice = new Employe("Alice", "Google");
        
        // нисходящее преобразование от Object к типу Employe

        Employe emp = (Employe)sam;
        emp.display();
        System.out.println(emp.getCompany());
        

        Employe emps = (Employe) sam;
        emps.display();
                 
        // или так

        ((Employe)sam).display();
        
        if(kate instanceof Employe){
            
            Employe employeeSam = (Employe) sam;
            employeeSam.display();
        }
        else{
                              
            System.out.println("Conversion is invalid");
        }
        
        // начиная с версии Java 16 мы можем упростить преобразование типов следующим образом:

        	
        if(kate instanceof Client clientSam){
        	     
        	    clientSam.display();
        }
        else{
        	                      
        	    System.out.println("Conversion is invalid");
        }

        AnonymousInner inner = new AnonymousInner() {
            public void mymethod() {
               System.out.println("Это пример анонимного внутреннего класса");
            }
         };
         inner.mymethod(); 

	}

}
