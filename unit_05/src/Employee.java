
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
	         
	        System.out.printf("Employee Name: %s \t Bank: %s \n", super.getName(), address);
	}
	
	public abstract double computedPay();
	// Остаток определения класса
}
