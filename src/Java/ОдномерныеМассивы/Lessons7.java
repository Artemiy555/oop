package Java.ОдномерныеМассивы;

public class Lessons7 {
    public static void main(String[] args) {
        System.out.println("Посчитать количество нечетных элементов массива");
        System.out.println(sumNecElements(new int[]{1,2,3,4}));
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
}
