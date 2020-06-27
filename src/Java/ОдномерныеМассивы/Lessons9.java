package Java.ОдномерныеМассивы;

import java.util.Arrays;

public class Lessons9 {
    public static void main(String[] args) {
        System.out.println("пузырьком (Bubble)");
        System.out.println(Arrays.toString(bubble(new int[]{1,2,3,4})));
        System.out.println("выбором (Select)");
        System.out.println(Arrays.toString(select(new int[]{1,2,3,4})));
        System.out.println("вставками (Insert)");
        System.out.println(Arrays.toString(insert(new int[]{1,2,3,4})));
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
}
