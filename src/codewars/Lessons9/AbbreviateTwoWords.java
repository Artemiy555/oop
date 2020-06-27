package codewars.Lessons9;

public class AbbreviateTwoWords {
    public static String abbrevName(String name) {
        String[] arr = name.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i].charAt(0) + ".");
            res.append(arr[i].charAt(0) + ".");
        }
        System.out.println(res);

        return res.substring(0, res.length() - 1);

    }
}
