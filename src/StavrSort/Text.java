package StavrSort;

import java.util.ArrayList;

import static org.apache.commons.math3.util.ArithmeticUtils.pow;

public class Text {

    public static void main(String[] args) {
        long start;
        long finish;
        long timeConsumedMillis;

        int a = 0; // Начальное значение диапазона - "от"
        long b = 2147483647; // Конечное значение диапазона - "до" для 30тс
        long c = 100000-1; // Конечное значение диапазона - "до" для 100тс
        long d = pow(2,15); // Конечное значение диапазона - "до" для 300тс
        long g = 2147483647; // Конечное значение диапазона - "до" для 1мл



        int[] thiT  = new int[30_000];
        for (int i = 0; i < thiT.length; i++) {
            thiT[i] = a + (int) (Math.random() * b);
        }
        int[] tenTT  = new int[100_000];
        for (int i = 0; i < tenTT.length; i++) {
            tenTT[i] = a + (int) (Math.random() * c);
        }
        int[] thiTT  = new int[300_000];
        for (int i = 0; i < thiTT.length; i++) {
            thiTT[i] = a + (int) (Math.random() * d);
        }
        int[] oneM  = new int[1_000_000];
        for (int i = 0; i < oneM.length; i++) {
            oneM[i] = a + (int) (Math.random() * g);
        }

        SortingClass sortingClass = new SortingClass();
        MergeSortList merger = new MergeSortList();

        ArrayList<Integer> thiTList = new ArrayList<Integer>();
        for (int i = 0; i < 30_000; i++) {
            thiTList.add(i);
        }

        ArrayList<Integer> tenTTList = new ArrayList<Integer>();
        for (int i = 0; i < 100_000; i++) {
            tenTTList.add(i);
        }

        ArrayList<Integer> thiTTList = new ArrayList<Integer>();
        for (int i = 0; i < 300_000; i++) {
            thiTTList.add(i);
        }
        ArrayList<Integer> oneMList = new ArrayList<Integer>();
        for (int i = 0; i < 1_000_000; i++) {
            oneMList.add(i);
        }
        System.out.println("Classic MargeSort");
        start = System.currentTimeMillis();
        sortingClass.mergeSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("30тс: "+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.mergeSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("100тс: "+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.mergeSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("300тс: "+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.mergeSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("1м: "+timeConsumedMillis);

        System.out.println("MargeSortList");
        start = System.currentTimeMillis();
        merger.merge_sort(thiTList);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("30тс: "+timeConsumedMillis);

        start = System.currentTimeMillis();
        merger.merge_sort(tenTTList);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("100тс: "+timeConsumedMillis);

        start = System.currentTimeMillis();
        merger.merge_sort(thiTTList);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("300тс: "+timeConsumedMillis);

        start = System.currentTimeMillis();
        merger.merge_sort(oneMList);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("1м: "+timeConsumedMillis);



    }
}
