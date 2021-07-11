
public class Employe extends Person {

	private String company;
    
    public Employe(String name, String company) {
        super(name);
        this.company = company;
    }
    
    public String getCompany() {
    	return company;
    }
    
    public void display(){
        
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), company);
    }

}
