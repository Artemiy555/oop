package codewars.Lessons5;

public class Kata {
    public static int[] invert(int[] array) {
        for (int i=0;i<array.length;i++){
            array[i] = array[i]*-1;
            System.out.println(array[i]);
        }
        return array;
    }
}
