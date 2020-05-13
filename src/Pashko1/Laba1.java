package Pashko1;

public class Laba1 {
    public static void main(String[] args) {
        int m = 32;
        int M = 65335;
        double n =  Math.pow(10,9);
        for(double i=0; i<=n; i++){
            i = i*M%Math.pow(2,m);

            System.out.println(i);
        }
    }
    }
