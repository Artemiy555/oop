package codewars.Lessons17;

public class Kata
{
    public static int expressionsMatter(int a, int b, int c)
    {
        int min ;
        int max = 0;
        min = a*(b+c);
        System.out.println(min);
        if(min>max)
            max = min;
        min = a*b*c;
        System.out.println(min);
        if(min>max)
            max = min;
        min = a+b*c;
        System.out.println(min);
        if(min>max)
            max = min;
        min = (a+b)*c;
        System.out.println(min);
        if(min>max)
            max = min;
        min = a+b+c;
        System.out.println(min);
        if(min>max)
            max = min;
        System.out.println();
        System.out.println();

        return max;
    }
}