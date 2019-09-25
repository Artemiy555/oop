package lessons9;

import java.util.*;

public class Mark{
    public static void main(String[] args) {
        double b = 0.0;
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list.add(i);
            b = b + (System.currentTimeMillis() - start);
        }
        System.out.println("Добавление ArrayList " + b/1000+"c");

        b=0.0;

        List<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list2.add(i);
            b = b + (System.currentTimeMillis() - start);
        }
        System.out.println("Добавление LinkedList " +  b/1000+"c");

        System.out.println("***********************************");

        b=0.0;

        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list.remove(0);
            b = b + (System.currentTimeMillis() - start);
        }
        System.out.println("Удаление ArrayList " +  b/1000+"c");


        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list2.remove(0);
            b = b + (System.currentTimeMillis() - start);
        }
        System.out.println("Удаление LinkedList " + (System.currentTimeMillis() - start));



    }
}