package Java.УсловныеOператоры;

public class Lessons4 {
    public static void main(String[] args) {
        System.out.println("Посчитать выражение макс(а*б*с, а+б+с)+3");
        System.out.println(max(2,3,4));
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
}
