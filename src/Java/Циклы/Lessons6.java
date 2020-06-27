package Java.Циклы;

public class Lessons6 {
    public static void main(String[] args) {
        System.out.println("Вывести число, которое является зеркальным отображением последовательности цифр заданного числа, например, задано число 123, вывести 321");
        System.out.println(reversNumbers(12));
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
