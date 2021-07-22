/**
 * 
 */

import com.mycompany.*;

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
		// TODO Auto-generated method stub
		
		IEmployee mary = new SalaryEmployee(2, "Mary", "Doolee", 444.99);
        System.out.printf("Payroll for: %d \t %s \t %s\n", mary.getId(), mary.getName(), mary.getCompany());
        System.out.printf("Employee  amount:\t %s \n", mary.calculate_payroll());
        System.out.println(mary.defaultMethod());

	}

}
