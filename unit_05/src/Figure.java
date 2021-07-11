
public abstract class Figure {

	float x; // x-координата точки
    float y; // y-координата точки
    
    double dim1;
    double dim2;
  
    Figure(float x, float y){
         
        this.x=x;
        this.y=y;
    }
    // абстрактный метод для получения периметра
    public abstract float getPerimeter();
    // абстрактный метод для получения площади
    public abstract float getArea();

}
