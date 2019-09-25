package Laba_CM_4;
//полином лагранжа
public class lagranch {
    public static void main(String[] args) {

        int size = 10;
        double xValues[] = new double[size];
        double yValues[] = new double[size];

        for (int i = 0; i < size; i++)
        {
            xValues[i] = i;
            yValues[i] = TestF((double)i);
        }

        System.out.println(InterpolateLagrangePolynomial(2.0, xValues, yValues, size));
    }


    public static double TestF(Double x){
        return  Math.pow(x,3) + 3*Math.pow(x,2) + 3*x + 1;
    }

    public static double InterpolateLagrangePolynomial(double x, double[] xValues, double[] yValues, int size)
    {
        double lagrangePol = 0;

        for (int i = 0; i < size; i++)
        {
            double basicsPol = 1;
            for (int j = 0; j < size; j++)
            {
                if (j != i)
                {
                    basicsPol *= (x - xValues[j])/(xValues[i] - xValues[j]);
                }
            }
            lagrangePol += basicsPol * yValues[i];
        }

        return lagrangePol;
    }

    }
