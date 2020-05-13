package lessons5;



public class Rectangle extends Shape {
        public Rectangle(double x,double y){
            super(x,y);
        }
    public double area(){

        return line1*line2/2;
    }
    public double perim(){

        return (line1+line2)*2;
    }
}
