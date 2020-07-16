package codewars.Lessons24;

public class Kata {
    public static double findUniq(double arr[]) {

        double res =  arr[0];
        for (int i = 1; i < arr.length; i++)
            Math.pow(res,arr[i]);
        return res;
    }
}
