package Java.ОдномерныеМассивы;

public class Lessons2 {

    public static void main(String[] args) {
        System.out.println("Найти максимальный элемент массива");
        System.out.println(maxElement(new int[]{1,2,3,4}));
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
}
