package Java.УсловныеOператоры;

public class Lessons1 {
    public static void main(String[] args) {
        System.out.println("Если а – четное посчитать а*б, иначе а+б");
        System.out.println(oneL(2,3));
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
}
