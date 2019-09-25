package lessons7;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Double> list = new MyArrayList<>();
        list.addElem(5.00);
        list.addElem(4.00);
        list.addElem(6.888);
        list.printList();
        System.out.println();

        MyArrayList<Double> list2 = new MyArrayList<>();
        list2.addElem(2.0);
        list2.addElem(3.7);
        list2.addElem(4.0);
        list2.printList();

        MyArrayList<Integer> list3 = new MyArrayList<>();
        list3.addElem(4);
        list3.addElem(3);
        list3.addElem(7);
        list3.printList();

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
}
