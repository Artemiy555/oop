package Lab3Voloh.src.main.java.lexer;

import java.util.*;
import java.util.stream.Stream;

public class Prepreprocessor {
    private static Map<String, String> trigraphs = new HashMap<>();

    static {
        trigraphs.put("??=", "#");
        trigraphs.put("??(", "[");
        trigraphs.put("??/", "\\");
        trigraphs.put( "??)", "]");
        trigraphs.put("??'", "^");
        trigraphs.put("??<", "{");
        trigraphs.put("??!", "|");
        trigraphs.put("??>", "}");
        trigraphs.put("??-", "~");
    }

    /*
    * C11 Standard Draft
    * 5.1.1.2 Translation phases
    */

    /*
    Phase 1.
    Physical source file multibyte characters are mapped, in an implementation- defined manner, to the source character
    set (introducing new-line characters for end-of-line indicators) if necessary. Trigraph sequences are replaced by
    corresponding single-character internal representations.
    */
    private static Stream<String> stage1(Stream<String> lines) {
        return lines.map(s -> {
                    final String[] x = {s};
                    trigraphs.forEach((trg, val) -> x[0] = x[0].replace(trg, val));
                    return x[0];
                }
        );
    }

    /*
    Phase 2.
    Each instance of a backslash character (\) immediately followed by a new-line character is deleted, splicing
    physical source lines to form logical source lines. Only the last backslash on any physical source line shall be
    eligible for being part of such a splice. A source file that is not empty shall end in a new-line character, which
    shall not be immediately preceded by a backslash character before any such splicing takes place.
     */
    private static Stream<String> stage2(Stream<String> lines) {
        List<String> spliced = new ArrayList<>();
        Iterator<String> it = lines.iterator();
        StringBuilder cur = new StringBuilder();
        while (it.hasNext()) {
            String s = it.next();
            if (s.endsWith("\\")) {
                s = s.substring(0, s.length() - 1);
                cur.append(s);
                continue;
            }
            cur.append(s);
            spliced.add(cur.toString());
            cur = new StringBuilder();
        }
        if (cur.length() > 0) {
            System.err.println("Error: last line ends with a backslash\n See standard:\n" +
                    "A source file that is not empty shall end in a new-line character, which shall not be " +
                    "immediately preceded by a backslash character before any such splicing takes place.");
            System.exit(3);
        }
        return spliced.stream();
    }

    public static Stream<String> preprocess(Stream<String> lines) {
        return stage2(stage1(lines));
    }
}
