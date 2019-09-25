package Laba_CM_2;
//прогонка
public class laba {
    public static void main(String[] args) {

        double[][] matrixA = new double[5][6];
        double[][] result = new double[5][6];

        matrixA[0][0] = 2;
        matrixA[0][1] = -1;
        matrixA[0][2] = 0;
        matrixA[0][3] = 0;
        matrixA[0][4] = 0;
        matrixA[0][5] = -25;

        matrixA[1][0] = -3;
        matrixA[1][1] = 8;
        matrixA[1][2] = -1;
        matrixA[1][3] = 0;
        matrixA[1][4] = 0;
        matrixA[1][5] = 72;

        matrixA[2][0] = 0;
        matrixA[2][1] = -5;
        matrixA[2][2] = 12;
        matrixA[2][3] = 2;
        matrixA[2][4] = 0;
        matrixA[2][5] = -69;

        matrixA[3][0] = 0;
        matrixA[3][1] = 0;
        matrixA[3][2] = -6;
        matrixA[3][3] = 18;
        matrixA[3][4] = -4;
        matrixA[3][5] = -156;

        matrixA[4][0] = 0;
        matrixA[4][1] = 0;
        matrixA[4][2] = 0;
        matrixA[4][3] = -5;
        matrixA[4][4] = 10;
        matrixA[4][5] = 20;



        double b =0;
        int k = 0;
        int j = 0;
        double f = matrixA[1][0];
        double a = 0;
        for(int i = 0;i<4;i++) {


            double y = matrixA[0+k][0+k] + (f * a);
            System.out.println(matrixA[0+k][0+k]+"+"+f+"*"+a+"="+y);
            System.out.println(y);
            System.out.println();
          //  f= matrixA[1+k][0+k];
            System.out.println(f);
            System.out.println();//работает


            a = -matrixA[0+k][1+k] / y;
            System.out.println(-matrixA[0+k][1+k]+"/"+y+"="+a);
            result[0+k][1+k]=a;


            System.out.println("это результат а "+result[0+k][1+k]);//работает


            double q = b;
            b = (matrixA[0+k][5] - matrixA[0+k][0] * b) / y;
            //System.out.println("//////////////////////////////////"+matrixA[1][5]);
            System.out.println("("+matrixA[0+k][5]+"+"+matrixA[0+k][0]+"*"+q+")/"+y+"="+b);

            result[0+k][5] = b;
            System.out.println(b+"\n");
            System.out.println();
            System.out.println();
            System.out.println();

            j++;
            j++;
            k++;
        }
        double x,z;
        z = result[0][5];
        for(int i = 1;i<5;i++) {

            System.out.println(result[4-i][5-i]);
            System.out.println(result[4-i][5]);
            x = result[4-i][5-i]*z+result[4-i][5];
            z=x;
            System.out.println("x"+i+" = "+x);

        }

    }
}
