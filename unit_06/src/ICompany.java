
public interface ICompany {
	public String getCompany();
	public String getName();
	public int getId();
	
    default String defaultMethod() {
        return "Объект типа String по умолчанию";
    }
}
