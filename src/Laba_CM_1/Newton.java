package Laba_CM_1;

import java.util.ArrayList;
import java.util.function.Function;

//Методом Хорд, касательных и Ньютона.
    public class Newton {
        public ArrayList<Double> totalfank(int start, int end, Function<Integer, Double> fanc) {
            ArrayList<Double> rsl = new ArrayList<>();
            for (int i = start; i < end; i++) {
                rsl.add(fanc.apply(i));
            }
            return rsl;
        }

        public static void main(String[] args) {
            Newton calculate = new Newton();
            System.out.println(calculate.totalfank(-2, 2, (x) -> {//интервал

                return Math.pow(x,4) - 3* Math.pow(x,3) + 20* Math.pow(x,2)+ 44+54;
            }));
        }
    }



