
public class Client extends Person {

	private String bank;
	private int number;
	
    public Client(String name, String company, 	int number) {
     
        super(name);
        this.bank = company;
        this.number = number;
    }
     
    public void display(){
         
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), bank);
    }

}
