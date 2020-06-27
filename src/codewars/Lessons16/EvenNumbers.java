package codewars.Lessons16;

import java.util.ArrayList;

public class EvenNumbers {

    public static int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++){
            if(numbers[i]%divider==0){
                arrayList.add(numbers[i]);
                System.out.println(numbers[i]);
            }

        }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
