package codewars.Lessons13;

public class RemoveChars {
    public static String remove(String str) {

        str = str.substring(1);//удаление первого
        str = str.substring(0, str.length() - 1);//удаление последенего
        return str;

    }
}
