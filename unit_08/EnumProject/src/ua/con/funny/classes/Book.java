package ua.con.funny.classes;

public class Book {
	public String name;
    public Type bookType;
    String author;
    
	public Book() {
		// TODO Auto-generated constructor stub
	}
	  
	public Book(String name, String author, Type type){
	        bookType = type;
	        this.name = name;
	        this.author = author;
	}
}
