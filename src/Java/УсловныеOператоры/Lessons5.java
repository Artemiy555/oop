package Java.УсловныеOператоры;

public class Lessons5 {
    public static void main(String[] args) {
        System.out.println("Написать программу определения оценки студента по его рейтингу, на основе следующих правил");
        System.out.println(mark(60));
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
