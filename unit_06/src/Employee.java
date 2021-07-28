/**
 * 
 */

/**
 * @author janus
 *
 */
public abstract class Employee implements ICompany
{
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

	
//	каждый обработанный Employee имел интерфейс .calculate_payroll(), который возвращает еженедельную зарплату сотруднику. 
//	Реализация этого интерфейса отличается в зависимости от типа Employee.
	
	public double calculate_payroll() {
		return 3.14;
	}
	
	public interface NestedIf {
        boolean isNotNegative(int x);
    }
}
