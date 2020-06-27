package codewars.Lessons4;

public class Maps {
    public static int[] map(int[] arr) {

        for (int i=0;i<arr.length;i++){
            arr[i] = arr[i]*2;
            System.out.println(arr[i]);
        }
        return arr;

    }
}
