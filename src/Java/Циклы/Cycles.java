package Java.Циклы;

import java.util.Arrays;

public class Cycles {

    public static void main(String[] args) {
        System.out.println("Найти сумму четных чисел и их количество в диапазоне от 1 до 99");
        System.out.println(Arrays.toString(sum()));
        System.out.println("Проверить простое ли число? (число называется простым, если оно делится только само на себя и на 1)");
        System.out.println(simpleNumber(5));
        System.out.println("Вариант последовательного подбора");
        System.out.println(sqrtOne(12));
        System.out.println("Метод бинарного поиска");
        System.out.println(sqrtTwo(12));
        System.out.println("Вычислить факториал числа n. n! = 1*2*…*n-1*n;!");
        System.out.println(factorial(5));
        System.out.println("Посчитать сумму цифр заданного числа");
        System.out.println(sumNumbers(12));
        System.out.println("Вывести число, которое является зеркальным отображением последовательности цифр заданного числа, например, задано число 123, вывести 321");
        System.out.println(reversNumbers(12));
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
    //2
    //  Проверить простое ли число? (число называется простым, если оно делится только само на себя и на 1)
    public static boolean simpleNumber(int number) {
        boolean result = true;
        for (int i = 2; i < number; i++) {
            if (number % i  == 0) {
                result = false;
            }
        }
        return result;
    }
    //3
    // Найти корень натурального числа с точностью до целого (рассмотреть вариант последовательного подбора и метод бинарного поиска)
    // Вариант последовательного подбора
    public static int sqrtOne(int number) {
        int i = 1;
        while (i * i <= number)
            i++;
        return i-1;
    }
    // Метод бинарного поиска
    public static int sqrtTwo(int number) {
        int result = number;

        while (result * result > number)
            result /= 2;
        while (result * result < number)
            result++;
        return result;
    }
    //4
    //  Вычислить факториал числа n. n! = 1*2*…*n-1*n;!
    public static int factorial(int number) {
        int result = 1;
        if (number > 1)
            for (int i = 2; i <= number; i++)
                result *= i;

        return result;
    }
    //5
    //  Посчитать сумму цифр заданного числа
    public static int sumNumbers(int number) {
        int result = 0;
        while (number != 0)
            result += number % 10;
            number /= 10;
        return result;
    }
    //6
    //  Вывести число, которое является зеркальным отображением последовательности цифр заданного числа, например, задано число 123, вывести 321.
    public static int reversNumbers(int a) {
        int result = 0;
        while (a > 0) {
            result = (result + (a % 10)) * 10;
            a = a / 10;
        }
        return result / 10;
    }

    }
