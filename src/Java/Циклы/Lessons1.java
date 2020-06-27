package Java.Циклы;

import java.util.Arrays;

public class Lessons1 {
    public static void main(String[] args) {
        System.out.println("Найти сумму четных чисел и их количество в диапазоне от 1 до 99");
        System.out.println(Arrays.toString(sum()));
    }
    //1
    // Найти сумму четных чисел и их количество в диапазоне от 1 до 99
    public static int[] sum() {
        int sum = 0, num = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 == 0) {
                sum += i;
                num++;
            }
        }
        return new int[] {sum, num};
    }
}
