package Java.УсловныеOператоры;

public class Lessons2 {
    public static void main(String[] args) {
        System.out.println("пределить какой четверти принадлежит точка с координатами (х,у)");
        System.out.println(quarter(2,3));
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
}
