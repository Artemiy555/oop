package dz2;

public class Rectangles extends Rectangle {
    private double z;






    public Rectangles(double x,double y,double z){
        super(x,y);
        this.z =z;
    }

  public double area(){

        System.out.println("Площа треугольника: ");
        return getX()*getY()*z;

    }

    public double perim(){

        System.out.println("Периметр треугольника: ");
        return getY()+getX()+z;
    }

    public double newshape(double line,double line1,double line2){
        System.out.println("Площа: ");
        return line1*line*line2*perim();

    }


}
