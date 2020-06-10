package OpenMP;

public class OpenPM {



    public static void main(String[] args) {
        double[] array = new double[1000];
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000;i++) {
            array[i] = (int) Math.round((Math.random() * 30) - 15);
            //System.out.println(array[i]);
        }
        System.out.println("\n");
        int left = 0, right = 1000 - 1;
        int flag = 1;



        //omp parallel
        {
            while ((left < right) && flag > 0) {
                flag = 0;
                //omp parallel for
                for (int i = left; i < right; i++)
                {
                    if (array[i] > array[i + 1])
                    {
                        double t = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = t;
                        flag = 1;
                    }
                }
                right--;
                //omp parallel for
                for (int i = right; i > left; i--)
                    if (array[i - 1] > array[i])
                    {
                        double t = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = t;
                        flag = 1;
                    }
            }
            left++;
        }



//        for (int i = 0; i<1000; i++)
//            System.out.println(array[i]);

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }

}

