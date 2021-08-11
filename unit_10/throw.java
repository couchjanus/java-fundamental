package ua.mycom;

public class Main {
	
	public static int getFactorial(int num){
	     
	    int result=1;
	    try{
	        if(num<1) throw new Exception("The number is less than 1");
	         
	        for(int i=1; i<=num;i++){
	             
	            result*=i;
	        }
	    }
	    catch(Exception ex){
	         
	        System.out.println(ex.getMessage());
	        result=num;
	    }
	    return result;
	}


	public static void main(String args[]) {
	    try{
	        int result = getFactorial(-6);
	         
	        System.out.println(result);
	    }
	    catch(Exception ex){
	         
	        System.out.println(ex.getMessage());
	    }
	}
}
