package lessons5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeRun {
    public static void main(String[] args) {
        double sheer = 1.00;
        double length = 1.00;
        double height = 1.00;

        try {


            Scanner in = new Scanner(System.in);
            System.out.print("Sheer: ");
             sheer = in.nextDouble();
            System.out.print("length: ");
             length = in.nextDouble();
            System.out.print("Height: ");
             height = in.nextDouble();

            in.close();
        }catch (Exception e){
            System.out.println("Введите дабл");

        }


        Rectangle rectangle = new Rectangle(sheer, length);
        Tringle triangle = new Tringle(sheer, length, height);




        List<Double> trianglePerim = new ArrayList<>();
        List<Double> triangleArea = new ArrayList<>();
        System.out.println(triangle.perim());
        trianglePerim.add(triangle.perim());
        System.out.println(triangle.area());
        triangleArea.add(triangle.area());

        System.out.println();

        List<Double> rectanglePerim = new ArrayList<>();
        List<Double> rectangleArea = new ArrayList<>();
        System.out.println(rectangle.perim());
        rectanglePerim.add(rectangle.perim());
        System.out.println(rectangle.area());
        rectanglePerim.add(rectangle.area());


    }
}