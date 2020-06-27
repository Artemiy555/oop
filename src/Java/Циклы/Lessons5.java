package Java.Циклы;

public class Lessons5 {
    public static void main(String[] args) {
        System.out.println("Посчитать сумму цифр заданного числа");
        System.out.println(sumNumbers(12));
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
}
