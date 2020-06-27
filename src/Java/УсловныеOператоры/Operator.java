package Java.УсловныеOператоры;

public class Operator {

    public static void main(String[] args) {
        System.out.println("Если а – четное посчитать а*б, иначе а+б");
        System.out.println(oneL(2,3));
        System.out.println("пределить какой четверти принадлежит точка с координатами (х,у)");
        System.out.println(quarter(2,3));
        System.out.println("Найти суммы только положительных из трех чисел");
        System.out.println(positive(2,3,4));
        System.out.println("Посчитать выражение макс(а*б*с, а+б+с)+3");
        System.out.println(max(2,3,4));
        System.out.println("Написать программу определения оценки студента по его рейтингу, на основе следующих правил");
        System.out.println(mark(60));
    }
    //1
    // Если а – четное посчитать а*б, иначе а+б
    public static int oneL(int a, int b) {
        int result;
        if (a % 2 == 0)
            result = a * b;
        else
            result = a + b;
        return result;
    }
    //2
    // Определить какой четверти принадлежит точка с координатами (х,у)
    public static int quarter(int a, int b) {
        int result;
        if (a > 0 && b > 0)
            result = 1;
        else if (a < 0 && b > 0)
            result = 2;
        else if (a < 0 && b < 0)
            result = 3;
        else result = 4;
        return result;
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

    //4
    //  Посчитать выражение макс(а*б*с, а+б+с)+3
    public static int max(int a, int b, int c) {
        int result;
        int x = a * b * c;
        int y = a + b + c;
        if (x > y)
            result = x;
        else result = y;
        return result + 3;
    }
    //5
    //  Написать программу определения оценки студента по его рейтингу, на основе следующих правил
    public static char mark(int a) {
        char result = 0;
        if (a >= 0 && a <= 19)
            result = 'F';
        else if (a >= 20 && a <= 39)
            result = 'E';
        else if (a >= 40 && a <= 59)
            result = 'D';
        else if (a >= 60 && a <= 74)
            result = 'C';
        else if (a >= 75 && a <= 89)
            result = 'B';
        else if (a >= 90 && a <= 100)
            result = 'A';
        return result;
    }
}
