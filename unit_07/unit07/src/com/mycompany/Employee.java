/**
 * 
 */
package com.mycompany;

/**
 * @author janus
 *
 */
public abstract class Employee implements IEmployee {

	/**
	 * 
	 */
	
	private int id;
	private String name;
	private String company;
	
	public Employee() {
	}
    	
	public Employee(int id, String name, String company ) {
		this.name=name;
		this.id = id;
		this.company = company;
	}
	public String getCompany() {
	      return company;
	}
	
	  public String getName() { 
	  	return name; 
	  }
	
	  public int getId() { 
	  	return id; 
	  }

}
