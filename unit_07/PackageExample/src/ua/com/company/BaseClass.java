package ua.com.company;

public class BaseClass {
	
	private    String id   = null;
    protected  String name = null;

    public BaseClass()
    {
        this.id   = "default";
        this.name = "Наименование не определено"; 
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.getClass().getName() + "\n\t{id = '" + 
                         id + "', name = '" + name + "'}";
    }

}
