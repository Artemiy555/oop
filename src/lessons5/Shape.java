package lessons5;

public abstract class Shape {
    double line1;
    double line2;


    public Shape(double x,double y){
        line1=x;
        line2=y;
    }

    public abstract double area();
    public abstract double perim();
}
