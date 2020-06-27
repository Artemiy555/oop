package codewars.Lessons14;

import java.util.Arrays;

public class ZywOo {

    public static int sumOfDifferences(int[] arr) {
        Arrays.setAll(arr, i -> ~arr[i]);
        Arrays.sort(arr);
        Arrays.setAll(arr, i -> ~arr[i]);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int sum = 0;
        int sacristy;
        for (int i = 0; i < arr.length-1; i++) {
        sacristy = arr[i]-arr[i+1];
        System .out.println(sacristy);
        sum+=sacristy;

        }
        return sum;
    }
}
