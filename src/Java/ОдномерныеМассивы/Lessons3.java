package Java.ОдномерныеМассивы;

public class Lessons3 {

    public static void main(String[] args) {
        System.out.println("Найти индекс минимального элемента массива");
        System.out.println(minIndex(new int[]{1,2,3,4}));
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
}
