package codewars.Lessons15;

public class Kata {

    public static String solution(String str) {
        char[] arrChar = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < arrChar.length+1; i++){
            try {
                result.append(arrChar[arrChar.length - i]);
                System.out.println(arrChar[arrChar.length - i]);
            }catch (Exception e){
                result.append(arrChar[0]);
                System.out.println(arrChar[0]);
                //e.printStackTrace();
            }
        }
        return result.toString();
    }


}
