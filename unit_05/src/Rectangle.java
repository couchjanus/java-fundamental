class Rectangle extends Figure
{
    private float width;
    private float height;
  
    // конструктор с обращением к конструктору класса Figure
    Rectangle(float x, float y, float width, float height){
         
        super(x,y);
        this.width = width;
        this.height = height;
    }
     
    public float getPerimeter(){
         
        return width * 2 + height * 2;
    }
     
    public float getArea(){
         
        return width * height;
    }
}