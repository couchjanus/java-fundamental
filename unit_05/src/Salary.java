
public class Salary extends Employee {
	   
	private double salary;   // Годовая заработная плата
	   
	public double computedPay() {
	      System.out.println("Вычисляем заработную плату для " + getName());
	      return salary/52;
	}
	

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
