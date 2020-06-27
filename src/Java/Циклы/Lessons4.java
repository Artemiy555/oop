package Java.Циклы;

public class Lessons4 {
    public static void main(String[] args) {
        System.out.println("Вычислить факториал числа n. n! = 1*2*…*n-1*n;!");
        System.out.println(factorial(5));
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
}
