package lessons11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tack1 {
    public static void main(String[] args) {

        String str = "#7!K#";
        String regex = "^#[34567]+([*]|!)[D-K]*#$";

        System.out.println(regex);
        System.out.println(str.matches(regex));


        String str2 = "aaaa #7!K# zzzzzz #3!K# tt";
        String regex2 = "#[34567]+([*]|!)[D-K]*#";

        System.out.println(regex2);
        System.out.println(str2.matches(regex2));

        Pattern p0 = Pattern.compile(regex2);
        Matcher m0 = p0.matcher(str2);

        System.out.println(m0.find());

        while (m0.find()) { String text = m0.group();
            System.out.println(text + " from " + m0.start() + " to " + m0.end());
        }
    }
}
