package Java.Циклы;

public class Lessons2 {
    public static void main(String[] args) {
        System.out.println("Проверить простое ли число? (число называется простым, если оно делится только само на себя и на 1)");
        System.out.println(simpleNumber(5));
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
}
