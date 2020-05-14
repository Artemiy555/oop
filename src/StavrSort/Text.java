package StavrSort;

import java.util.Arrays;

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

        System.out.println("stable-sort");



        System.out.println("Radix sort Java implementation");


        System.out.println("LSD radix sort");



        System.out.println("Multi-pivot Quicksort by Yaroslavskiy");


        System.out.println("IntroSort");
        start = System.currentTimeMillis();
        sortingClass.introSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.introSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.introSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.introSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        System.out.println("Arrays.sort ()");
        start = System.currentTimeMillis();
        Arrays.sort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);
        start = System.currentTimeMillis();
        Arrays.sort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);
        Arrays.sort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);
        Arrays.sort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);


    }
}
