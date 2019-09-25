package lessons9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Tack1 {
    public static  void  main(String[] args){
        List<String> list = new ArrayList<>();
        long start;
        System.out.println(list.size());
        list.add("Anna");
        list.add("Zarina");
        list.add("Mark");
        list.add("John");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains("John"));
        System.out.println(list.contains("Kate"));
        System.out.println(list.remove("John"));
        System.out.println(list);
        System.out.println(list.size());

        for(String str: list){          //выводимвсе
            System.out.println("STR = " + str);
        }
        Iterator iter =list.iterator(); //Итератор
        while (iter.hasNext()){
            System.out.println("STR = " + iter.next());
        }


        System.out.println("*********************************************************");


        List<String> list1 = new ArrayList<>();

        System.out.println(list1.size());
        list1.add("Anna");
        list1.add("Zarina");
        list1.add("Mark");
        list1.add("John");
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.contains("John"));
        System.out.println(list1.contains("Kate"));
        System.out.println(list1.remove("John"));
        System.out.println(list1);
        System.out.println(list1.size());

        start = System.currentTimeMillis();

        List<Integer> abs = new ArrayList<>();
        for(int i = 0;i<100;i++){
            abs.add(i);
        }
        System.out.println(abs.size());

        System.out.println(System.currentTimeMillis() - start);

        String[] arr = {"Брук","Грей","Баран"};
        List<String> list5 = Arrays.asList(arr);
        System.out.println(list5);
        System.out.println();

        list = list5;
        list1 = list5;
        System.out.println(list);
        System.out.println(list1);



    }

}
