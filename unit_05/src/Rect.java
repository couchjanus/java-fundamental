
public class Rect extends Figures {

	public Rect(double a, double b) {
		// TODO Auto-generated constructor stub
		super(a, b);
	}
	    
    // переопределяем метод
    double area() {
        return dim1 * dim2;
    }
    
    double perimeter(){
        return dim1 * 2 + dim2 * 2;
    }

    
}
