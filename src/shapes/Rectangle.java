package shapes;

public class Rectangle extends Quadrilateral implements Measurable{
//    protected double length;
//    protected double width;

    public Rectangle(double length, double width){
        super(length, width);
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPerimeter(){
        return (this.length * 2) + (this.width * 2);
    }

    public double getArea(){
        return (this.length * this.width);
    }
}
