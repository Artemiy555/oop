package Java.ОдномерныеМассивы;

public class Lessons5 {

    public static void main(String[] args) {
        System.out.println("Посчитать сумму элементов массива с нечетными индексами");
        System.out.println(sumElementsIndex(new int[]{1,2,3,4}));
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
}
