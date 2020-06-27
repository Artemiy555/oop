package Java.УсловныеOператоры;

public class Lessons3 {
    public static void main(String[] args) {
        System.out.println("Найти суммы только положительных из трех чисел");
        System.out.println(positive(2,3,4));
    }
    //3
    //  Найти суммы только положительных из трех чисел
    public static int positive(int a, int b, int c) {
        int result = 0;
        if (a > 0)
            result += a;
        if (b > 0)
            result += b;
        if (c > 0)
            result += c;

        return result;
    }
}
