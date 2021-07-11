
public abstract class Figures {
	double dim1;
    double dim2;

	Figures(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    
    // абстрактный метод для вычисления площади
    abstract double area();

}
