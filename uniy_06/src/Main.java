/**
 * 
 */

/**
 * @author janus
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		HourlyEmployee bob = new HourlyEmployee(1, "Bob", "Goolee", 20, 77.88);
//		
//	  	System.out.printf("Payroll for: %d \t %s \t %s\n", bob.getId(), bob.getName(), bob.getCompany());
//        System.out.printf("Employee  amount:\t %s \n", bob.calculate_payroll());
//		
//        SalaryEmployee mary = new SalaryEmployee(2, "Mary", "Doolee", 444.99);
//        System.out.printf("Payroll for: %d \t %s \t %s\n", mary.getId(), mary.getName(), mary.getCompany());
//        System.out.printf("Employee  amount:\t %s \n", mary.calculate_payroll());
//        
        
        IEmployee bob = new HourlyEmployee(1, "Bob", "Goolee", 20, 77.88);
        System.out.printf("Payroll for: %d \t %s \t %s\n", bob.getId(), bob.getName(), bob.getCompany());
        System.out.printf("Employee  amount:\t %s \n", bob.calculate_payroll());
        System.out.println(bob.defaultMethod());
        
        System.out.println(IEmployee.staticMethod());
        
        
        System.out.println(bob.sum(1, 2));
        System.out.println(bob.sum(1, 2, 4));
        
		
        IEmployee mary = new SalaryEmployee(2, "Mary", "Doolee", 444.99);
        System.out.printf("Payroll for: %d \t %s \t %s\n", mary.getId(), mary.getName(), mary.getCompany());
        System.out.printf("Employee  amount:\t %s \n", mary.calculate_payroll());
        System.out.println(mary.defaultMethod());
        
        
        Employee.NestedIf nif = new HourlyEmployee(1, "Nif", "Noolee", 20, 77.88);
        if (nif.isNotNegative(10)) {
            System.out.println("Число 10 не отрицательное.");
        }
        if (nif.isNotNegative(-12)) {
            System.out.println("Этo не будет выведено.");
        }
        
        
        WaterPipe pipe = new WaterPipe();
        pipe.printState(1);

      //      
      CommissionEmployee sam = new CommissionEmployee(new SalaryEmployee(3, "Sam", "Soolee", 999.99), 555.99);
      System.out.printf("Payroll for: %d \t %s \t %s\n", sam.obj.getId(), sam.obj.getName(), sam.obj.getCompany());
      System.out.printf("Employee  amount:\t %s \n", sam.calculate_payroll());

        
	}
}
