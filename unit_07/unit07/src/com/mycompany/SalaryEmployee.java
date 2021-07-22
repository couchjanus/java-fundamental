/**
 * 
 */
package com.mycompany;

/**
 * @author janus
 *
 */
public class SalaryEmployee extends Employee {

	/**
	 * 
	 */
	double weekly_salary;
	
	public SalaryEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public SalaryEmployee(int id, String name, String company, double weekly_salary) {
		super(id, name, company);
		this.weekly_salary = weekly_salary;
		
	}

	/**
	 * административные работники имеют фиксированную зарплату, 
	 * поэтому каждую неделю им платят одну и ту же сумму
	 */
	
	public double calculate_payroll() {
		return this.weekly_salary;
	}
	
	public void display(){
	  System.out.printf("Employee Name: %s \t Id: %d \n", super.getName(), getId());
	}
	
	@Override
    public String defaultMethod() {
        return "Другая символьная строка";
    }

}
