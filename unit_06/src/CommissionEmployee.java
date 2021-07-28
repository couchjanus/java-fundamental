/**
 * 
 */

/**
 * 
 * в компании работают торговые партнеры, которым выплачивается фиксированная зарплата плюс комиссия, 
 * основанная на их продажах, поэтому мы создадим класс CommissionEmployee
 * @author janus
 *
 */
public class CommissionEmployee extends Employee implements IEmployee {

	/**
	 * 
	 */

	double commission;
	
	SalaryEmployee obj;

	public CommissionEmployee(SalaryEmployee o, double commission)
	{
		this.obj = o;
		
		this.commission = commission;
	}

	public double calculate_payroll() {
		double fixed = obj.calculate_payroll();
		return fixed + this.commission;
	}

}
