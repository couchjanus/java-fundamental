/**
 * 
 */
package com.mycompany;

/**
 * @author janus
 *
 */
public interface IEmployee extends ICompany{
	public String getCompany();
	public String getName();
	public int getId();
	
	// public double calculate_payroll();
	
    default String defaultMethod() {
        return "Объект типа String по умолчанию";
    }

}
