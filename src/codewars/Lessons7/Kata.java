package codewars.Lessons7;

public class Kata {
    public static String well(String[] x) {
        int n = 0;
        for (int i=0;i<x.length;i++){
            System.out.println(x[i]);
            if(x[i].equals("good"))
            n++;
            System.out.println(n);
        }

       if (n>=2){
           return "I smell a series!";
       }
       else if(n==0){
           return"Fail!";
       }
       else return "Publish!";
    }
}
