class Triangle extends Figures {

	Triangle(double a, double b) {
        super(a, b);
    }
    
    // переопределяем метод
    double area() {
        return dim1 * dim2 / 2;
    }
}
