package Java.ОдномерныеМассивы;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        System.out.println("Найти минимальный элемент массива");
        System.out.println(minElement(new int[]{1,2,3,4}));
        System.out.println("Найти максимальный элемент массива");
        System.out.println(maxElement(new int[]{1,2,3,4}));
        System.out.println("Найти индекс минимального элемента массива");
        System.out.println(minIndex(new int[]{1,2,3,4}));
        System.out.println("Найти индекс максимального элемента массива");
        System.out.println(maxIndex(new int[]{1,2,3,4}));
        System.out.println("Посчитать сумму элементов массива с нечетными индексами");
        System.out.println(sumElementsIndex(new int[]{1,2,3,4}));
        System.out.println("Сделать реверс массива (массив в обратном направлении)");
        System.out.println(Arrays.toString(reversArr(new int[]{1,2,3,4})));
        System.out.println("Посчитать количество нечетных элементов массива");
        System.out.println(sumNecElements(new int[]{1,2,3,4}));
        System.out.println("Поменять местами первую и вторую половину массива");
        System.out.println(Arrays.toString(revers(new int[]{1,2,3,4})));
        System.out.println("пузырьком (Bubble)");
        System.out.println(Arrays.toString(bubble(new int[]{1,2,3,4})));
        System.out.println("выбором (Select)");
        System.out.println(Arrays.toString(select(new int[]{1,2,3,4})));
        System.out.println("вставками (Insert)");
        System.out.println(Arrays.toString(insert(new int[]{1,2,3,4})));
    }
    //1
    //  Найти минимальный элемент массива
    public static int minElement (int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < result)
                result = arr[i];
        return result;
    }
    //2
    //  Найти максимальный элемент массива
    public static int maxElement (int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > result)
                result = arr[i];
        return result;
    }
    //3
    //  Найти индекс минимального элемента массива
    public static int minIndex(int[] arr) {
        int result = 0, minEl = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < minEl) {
                result = i;
                minEl = arr[i];
            }
        return result;
    }
    //4
    //  Найти индекс максимального элемента массива
    public static int maxIndex(int[] arr) {
        int result = 0, maxEl = arr[0];
        for (int i = 0; i <= arr.length; i++)
            if (arr[i] > maxEl) {
                result = i;
                maxEl = arr[i];
            }
        return result;
    }
    //5
    //  Посчитать сумму элементов массива с нечетными индексами
    public static int sumElementsIndex(int[] arr) {
        int result = 0;
        for (int i = 0; i <= arr.length; i++)
            if (i % 2 == 0)
                result += arr[i];
        return result;
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
    }
    //7
    //  Посчитать количество нечетных элементов массива
    public static int sumNecElements(int[] arr)
    {
        int result = 0;
        for (int currentElement : arr)
            if (currentElement % 2 != 0)
                result++;
        return result;
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
    //9
    //Отсортировать массив (пузырьком (Bubble), выбором (Select), вставками (Insert))
    //пузырьком (Bubble)
    public static int[] bubble(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }
    //выбором (Select)
    public static int[] select(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minId = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[minId])
                    minId = j;
            int temp = arr[minId];
            arr[minId] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    //вставками (Insert)
    public static int[] insert(int arr[]){
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    //10
    //У меня есть проект по сорировкам и их сравнение, который писал для уника.
    //https://github.com/Artemiy555/oop/tree/master/src/StavrSort
}
