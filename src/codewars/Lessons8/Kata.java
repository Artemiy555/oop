package codewars.Lessons8;

public class Kata {
    public static int[] countPositivesSumNegatives(int[] input)
    {
        int n =0;
        int sum= 0;
        for (int i=0;i<input.length;i++){
            System.out.println(input[i]);
            if (Math.signum(input[i])==1)
                n++;
            else
                sum +=input[i];

        }
        System.out.println(n);
        System.out.println(sum);
        int arr[]=new int[]{n,sum};

        return arr;
    }
}
