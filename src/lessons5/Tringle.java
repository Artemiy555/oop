package lessons5;



public class Tringle extends Shape {
    double z;
    public Tringle(double x,double y,double z){

        super(x,y);
        this.z =z;
    }
    public double area(){
        //System.out.println("Super: "+ super.area());
        //System.out.print();
        return line1*line2*z;
    }
    public double perim(){
       // System.out.print();
        return (line1+line2)*z;
    }
}
