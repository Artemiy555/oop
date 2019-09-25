package lessons4;

import java.util.ArrayList;

public class shapeRun {
    public static void main(String[] args) {

        shape figur = new shape(50,2.5);
        shape rectangle = new Rectangle(2,4);
        Tringle triangle = new Tringle(2,4,5);



        //System.out.println(triangle);
       System.out.println(triangle.area());
     //   System.out.println(triangle.perim());


        // Rectangle rec2;


        // System.out.println(rec2.perim());
        // rec2 = (Rectangle) rectangle;
        //if(rec2 instanceof Rectangle)
        //   shape ff;

        //   ff = rectangle;
        //   System.out.println(ff.area());
        //  ff = triangle;
        //  System.out.println(ff.area());
        //   ff = figur;
        //  System.out.println(ff.area());
      //  ArrayList<shape> list = new ArrayList<>();
      //  list.add(rectangle);
      //  list.add(triangle);

      //  for (shape fig: list){
      //      System.out.println(fig.area());
      //  }


      //  System.out.println(figur.area());
     //   System.out.println(rec.area());
      //  System.out.println(rec.perim());
       // System.out.println(tri.area());
    }

}
