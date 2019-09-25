package lessons4;

public class Rectangle extends shape{
    public Rectangle(double x,double y){
        super(x,y);
    }
    public double area(){
        System.out.print( "Площадь треугольника: ");
        return line1*line2/2;
    }
    public double perim(){
        System.out.print( "Периметр прямоугольника: ");
        return (line1+line2)*2;
    }
}
