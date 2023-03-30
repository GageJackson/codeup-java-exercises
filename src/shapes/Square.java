package shapes;

public class Square extends Rectangle{
    double side;
    public Square(double side){
        super(side, side);
        this.side = side;
    }

    public double getPerimeter(){
//        System.out.println("From Square");
        return (this.side * 4);
    }

    public double getArea(){
//        System.out.println("From Square");
        return (this.side * this.side);
    }
}
