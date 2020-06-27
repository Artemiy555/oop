package Java.ОдномерныеМассивы;

import java.util.Arrays;

public class Lessons6 {

    public static void main(String[] args) {

        System.out.println("Сделать реверс массива (массив в обратном направлении)");
        System.out.println(Arrays.toString(reversArr(new int[]{1,2,3,4})));
    }
    //6
    //  Сделать реверс массива (массив в обратном направлении)
    public static int[] reversArr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }}