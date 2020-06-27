package Java.ОдномерныеМассивы;

public class Lessons4 {

    public static void main(String[] args) {
        System.out.println("Найти индекс максимального элемента массива");
        System.out.println(maxIndex(new int[]{1,2,3,4}));
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
}
