package mnk;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class mnk {
    public static void main(String[] args) {
        final OLSMultipleLinearRegression regression2 = new OLSMultipleLinearRegression();
        double[] y = {
                4,
                8,
                13,
                18
        };
        double[][] x2 =
                {
                        { 1, 1, 1  },
                        { 1, 2, 4  },
                        { 1, 3, 9  },
                        { 1, 4, 16  },
                };

        regression2.newSampleData(y, x2);
        regression2.setNoIntercept(true);
        regression2.newSampleData(y, x2);
        double[] beta = regression2.estimateRegressionParameters();
        for (double d : beta) {
            System.out.println("D: " + d);
        }
    }
}
