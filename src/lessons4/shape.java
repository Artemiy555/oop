package lessons4;

public class shape {

    double line1;
    double line2;


    public shape(double x,double y){
        line1=x;
        line2=y;

    }

    public double area(){
        System.out.print( "Площадь: ");
                return line1*line2;
    }



}
