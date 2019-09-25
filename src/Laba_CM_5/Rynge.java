package Laba_CM_5;


import static java.lang.Math.abs;

public class Rynge {


    static double rung(float a, float b, int n1) {
        float h1, sum, x;
        int i, k;
        sum = 0;
        h1 = (b - a) / n1;
        sum += a;
        System.out.println();
        System.out.println();
        for (i = 1; i < n1; i++) {
            x = a + i * h1;
            if (i % 2 == 0) k = 2;
            else k = 4;
            sum += k * x;
        }
        System.out.println();

        x = a + n1 * h1;
        sum += x;
        return 0.166 * h1 * sum;
    }

    static double f(double a, double b, double n) {
        double dx = (b - a) / n;
        double sum1 = a + dx / 2;
        double sum2 = 0;
        for (int i = 1; i < n; i++) {
            sum1 += a + dx * i + dx / 2;
            sum2 += a + dx * i;
        }
        return (dx / 6) * a + b + 4 * sum1 + 2 * sum2;
    }

    static float integrate(float a, float b, float eps) {
        int n = 1000;
        float l, k;
        k = (float) f(a, b, n);
        do {
            l = k;
            n = n * 2;
            k = (float) f(a, b, n);

        } while (l - k < eps);
        return k;

    }

    public static void main(String[] args) {

        double a, b, c, d, rez, run;

        int n1 = 15;
        a = 2;
        b = 4;
        double eps = 0.0001;
        System.out.println("\nЗначение интеграла \n");
        rez = integrate((float) a, (float) b, (float) eps);
        System.out.println("Метод Симпсона: \n" + rez);
        run = rung((float) a, (float) b, n1);
        System.out.println("Правило Рунге:\n" + (abs(rez - run)) / 15);


    }

    public float funct(float x) {
        return x * x * x - x;
    }

    double simps(float a, float b, int n) {
        float h, sum, x;
        int i, k;
        sum = 0;
        h = (b - a) / n;
        sum += a;
        for (i = 1; i < n; i++) {
            x = a + i * h;
            if (i % 2 == 0) k = 2;
            else k = 4;
            sum += k * x;
        }
        x = a + n * h;
        sum += x;
        return 0.166 * h * sum;
    }


}
