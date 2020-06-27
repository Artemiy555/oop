package Java.ОдномерныеМассивы;

import java.util.Arrays;

public class Lessons8 {
    public static void main(String[] args) {
        System.out.println("Поменять местами первую и вторую половину массива");
        System.out.println(Arrays.toString(revers(new int[]{1,2,3,4})));
    }
    //8
    //Поменять местами первую и вторую половину массива
    public static int[] revers(int[] arr){
        int mod = arr.length % 2;

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length / 2 + i + mod];
            arr[arr.length / 2 + i + mod] = temp;
        }
        return arr;
    }
}
