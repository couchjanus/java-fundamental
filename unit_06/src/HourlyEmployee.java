/**
 * 
 */

/**
 * 
 * В компании также работают рабочие, которые получают почасовую оплату, 
 * поэтому мы добавим HourlyEmployee в систему управления персоналом:

 * @author janus
 *
 */
public class HourlyEmployee extends Employee implements IEmployee, Employee.NestedIf {

	/**
	 * 
	 */

	int hours_worked;
	double hour_rate;

	// String company;
	
	public HourlyEmployee(int id, String name, String company, 	int hours_worked, double hour_rate) {
		super(id, name, company);
		this.hour_rate = hour_rate;
		this.hours_worked = hours_worked;
	}
	
	public double calculate_payroll() {
		return this.hour_rate * hours_worked;
	}
	
	public boolean isNotNegative(int x) {
        return x >= 0;
    }
}
