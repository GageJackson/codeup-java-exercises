package shapes;

public class Square extends Quadrilateral implements Measurable{
//    protected double length;
//    protected double width;
    Square(double side) {
        super(side, side);
    }

    public double getPerimeter() {
        return this.width * 4;
    }

    public double getArea() {
        return this.length * this.width;
    }

    protected void setLength(double length) {
        this.length = length;
    }

    protected void setWidth(double width) {
        this.width = width;
    }
}
