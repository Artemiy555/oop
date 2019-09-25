package Laba_CM_4;

public class PolinomNewtona {

    public static void main(String[] args) {
        double x = 3.2;
        double step=1;
        int n = 10;
        double[] MasX ={0, 1, 2, 3,4,5,6,7,8,9};
        double[] MaxY ={0, 1, 8, 27,64,125,216,343,512,729};

        double a = Newton(x, n, MasX, MaxY, step);
        System.out.println(a);
    }

    //від 0 до n-1
    //3 доданків
    //в знаменну 9
    //звести всі доданки
    // x - координата, в которой необходимо вычислить значение полинома Ньютона; n - количество узлов; MasX - массив x; MasY - массив значений y; step - шаг
    public static double Newton(double x, int n, double[] MasX, double[] MasY, double step) {

        double[][] mas = new double[n + 2][ n +1];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < n + 1; j++)
            {
                if (i == 0)
                    System.out.println("i = "+i);
                    System.out.println("j = "+j);
                   try {
                       mas[i][j] = MasX[j];
                   }catch (Exception e){

                   }
               if (i == 1)
                    try {
                        mas[i][j] = MasY[j];
                    }catch (Exception e){

                    }
            }
        }
        int m = n;
        for (int i = 2; i < n + 2; i++)
        {
            for (int j = 0; j < m; j++)
            {
                mas[i][ j] = mas[i - 1][ j + 1] - mas[i - 1][ j];
            }
            m--;
        }

        double[] dy0 = new double[n + 1];

        for (int i = 0; i < n + 1; i++)
        {
            dy0[i] = mas[i + 1][ 0];
        }

        double res = dy0[0];
        double[] xn = new double[n];
        xn[0] = x - mas[0][ 0];

        for (int i = 1; i < n; i++)
        {
            double ans = xn[(int) (i - 1)] * (x - mas[0][ i]);
            xn[i] = ans;
            ans = 0;
        }

        int m1 = n + 1;
        int fact = 1;
        for (int i = 1; i < m1; i++)
        {
            fact = fact * i;
            res = res + (dy0[i] * xn[i - 1]) / (fact * Math.pow(step, i));
        }

        return res;
    }




}
