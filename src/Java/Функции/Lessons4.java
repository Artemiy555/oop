package Java.Функции;

public class Lessons4 {
    public static void main(String[] args) {
    System.out.println(twoPoint(1,2,3,4));
    }
    public static double twoPoint(int x1,int y1, int x2,int y2){
        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);
        return Math.hypot(ac, cb);
    }
}
