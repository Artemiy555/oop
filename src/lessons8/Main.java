package lessons8;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Object> list = new MyArrayList<>();
        list.addElem("dfgdfgd");
        list.addElem(4);
        list.addElem(6.888);
        list.printList();
        System.out.println();


        Count test = new Count(16,16.88);
        System.out.println(test.multDouble(16 ,16.88));

        System.out.println(test.minusInt(16 ,16.88));

       // Div one = new Div(3,4);
       // Div two = new Div(3.5,4.5);

    }

    public static class MyArrayList <T> {
        ArrayList<T> list = new ArrayList<T>();

        public  ArrayList<T> addElem(T s) {
            list.add(s);
            return list;
        }

        public void printList(){
            for (T elem: list
                    ) {
                System.out.print(elem + " ");
            }
        }

    }

    public static class Count <K extends Number, V extends Number> {
        K x;
        V y;

        public Count(K x, V y) {
            this.x = x;
            this.y = y;
        }

        public double multDouble(K a, V b) {
            return (double)(b.doubleValue() + b.doubleValue());
        }

        public int minusInt(K a, V b) {

            return (a.intValue() - 2) ;
        }
    }


}