package lessons5;




public class ShapeRun {
    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle(2, 4);
        Tringle triangle = new Tringle(2, 6, 5);

        System.out.println(triangle.perim());
        System.out.println(triangle.area());

        System.out.println();

        System.out.println(rectangle.perim());
        System.out.println(rectangle.area());


    }
}