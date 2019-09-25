package Laba_CM_1;

import java.util.Scanner;

public class Delenie {
    // Метод деления отрезка пополам
        public static double func(double x) {
            return  Math.pow(x,4) - 3* Math.pow(x,3) + 20* Math.pow(x,2)+ 44*x+54;
        }

        public static void main(String[] args) {
            Delenie obj = new Delenie();

            Scanner scan = new Scanner(System.in);
            double a, b;
            double delta, epselon;
            a = 0;
            b = 1.5;
            delta = 0;
            epselon = 0.00001;
            System.out.println("The end of putting in");

            int n = 1;
            double u1, u2, x, J;
            while(b - a >= epselon) {
                n = n + 1;
                u1 = (b + a - delta)/2;
                u2 = (b + a + delta)/2;
                if(obj.func(u1) < obj.func(u2))//Якщо  , то ітераційний процес зупинимо і будемо вважати, що  .
                    b = u2;
                else if(obj.func(u1) > obj.func(u2))
                    a = u1;
                else if(obj.func(u1) == obj.func(u2)) {
                    b = u2;
                    a = u1;
                }
                x = (b + a)/2;
                System.out.println(x);
                J = obj.func(x);
                System.out.println("J = " + J + ", num of iterations - " + n);
            }
        }
    }


