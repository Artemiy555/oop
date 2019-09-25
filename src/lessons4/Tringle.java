package lessons4;

public class Tringle extends shape {
    double z;
    public Tringle(double x,double y,double z){

        super(x,y);
        this.z =z;
    }
    public double area(){
        System.out.println("Super: "+ super.area());
        System.out.print( "Площадь: ");
        return line1*line2*z;
    }
    public double perim(){
        System.out.print( "Периметр прямоугольника: ");
        return (line1+line2)*2;
    }


}
