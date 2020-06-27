package Java.ОдномерныеМассивы;

public class Lessons1 {

    public static void main(String[] args) {
        System.out.println("Найти минимальный элемент массива");
        System.out.println(minElement(new int[]{1,2,3,4}));
    }
    public static int minElement (int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < result)
                result = arr[i];
        return result;
    }
}
