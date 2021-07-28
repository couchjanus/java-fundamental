package ua.con.funny;

public enum XColor {
	RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
    private String code;
    XColor(String code){
        this.code = code;
    }
    public String getCode(){ return code;}
}
