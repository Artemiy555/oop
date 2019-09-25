package dz2;

public class Rectangle {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double Area(){
        System.out.println("Площа прямоугольника: ");
        return x*y;

    }
    public double perim(){
        double perim = 2*(x+y);
        System.out.println("Периметр прямоугольника: ");
        return perim;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
