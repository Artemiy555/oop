package Java.Циклы;

public class Lessons3 {
    public static void main(String[] args) {
        System.out.println("Вариант последовательного подбора");
        System.out.println(sqrtOne(12));
        System.out.println("Метод бинарного поиска");
        System.out.println(sqrtTwo(12));
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
}
