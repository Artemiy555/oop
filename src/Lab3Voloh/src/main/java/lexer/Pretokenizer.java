package Lab3Voloh.src.main.java.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Pretokenizer {

    public enum TokenType {
        HEADER_NAME(Pretokenizer.HEADER_NAME),
        IDENTIFIER(Pretokenizer.IDENTIFIER),
        PP_NUMBER(Pretokenizer.PP_NUMBER),
        CHAR_CONSTANT(Pretokenizer.CHAR_CONSTANT),
        STRING_LITERAL(Pretokenizer.STRING_LITERAL),
        PUNCTUATOR(Pretokenizer.PUNCTUATORS),
        CPP_COMMENT(Pretokenizer.CPP_COMMENT),
        C_COMMENT(Pretokenizer.C_COMMENT),
        WS("\\b\\B"),
        NEWLINE("\\b\\B"),
        MISC(".");

        private Pattern pattern;

        TokenType(String s) {
            pattern = Pattern.compile(s);
        }

        public static Token matchString(String s, boolean in_directive) {
            List<Token> tokens = new ArrayList<>();
            for (TokenType t : TokenType.values()) {
                if (!in_directive && t == HEADER_NAME)
                    continue;
                Matcher m = t.pattern.matcher(s);
                if (m.lookingAt()) {
                    tokens.add(new Token(t, m.group(0)));
                }
            }
            return tokens.stream().max(Comparator.comparingInt(x -> x.value.length())).orElse(null);
        }
    }

    public static class Token {
        public final TokenType type;
        public final String value;

        public Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    private static String punctuators = Arrays.asList("[", "]", "(", ")", "{", "}", ".", "->", "++", "--", "&", "*", "+", "-",
            "~", "!", "/", "%", "<<", ">>", "<", ">", "<=", ">=", "==", "!=",  "^",  "|", "&&", "||", "?", ":", ";",
            "...", "=", "*=", "/=", "%=", "+=", "-=", "<<=", ">>=", "&=", "^=", "|=", ",", "#", "##",
            "<:", ":>", "<%", "%>", "%:", "%:%:")
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|", "(", ")"));

    private static final String HEXD = "([\\da-fA-F])";
    private static final String UCN = "(\\\\u" + HEXD + "{4}|\\\\U" + HEXD + "{8})";
    private static final String IDND = "([a-zA-Z_]|" + UCN + ")";
    private static final String ESCAPE_SEQUENCE = "(\\\\['\"?\\\\abfnrtv]|\\\\[0-7]{1,3}|\\\\x" + HEXD + "+|"+ UCN + ")";

    static final String HEADER_NAME = "(<[^>]+>|\"[^\"]+\")";
    static final String IDENTIFIER = "(" + IDND + "(\\w|" + UCN + ")*)";
    static final String PP_NUMBER = "(\\.?\\d(\\d|" + IDND + "|[eEpP][+-]|\\.)*)";
    static final String CHAR_CONSTANT = "([LuU]?'([^'\\\\]|" + ESCAPE_SEQUENCE + ")')";
    static final String STRING_LITERAL = "(u[8]|U|L)?\"([^\\\\\"]|" + ESCAPE_SEQUENCE + ")*\"";
    static final String PUNCTUATORS = punctuators;

    static final String CPP_COMMENT = "(//)";
    static final String C_COMMENT = "(/\\*)";

    private Stream<String> lines;
    private List<Token> tokens = new ArrayList<>();

    private boolean in_c_comment = false;

    public Pretokenizer(Stream<String> lines) {
        this.lines = lines;
    }

    private void process() {
        lines.forEach(this::eatLine);
    }

    private void eatLine(String s) {
        if (in_c_comment) {
            int i = s.indexOf("*/");
            if (i == -1)
                return;
            in_c_comment = false;
            tokens.add(new Token(TokenType.WS, " "));
            s = s.substring(i + 2);

        }
        boolean in_directive = false;
        if (s.startsWith("#")) {
            in_directive = true;
            s = s.substring(1);
            tokens.add(new Token(TokenType.PUNCTUATOR, "#"));
        }
        Token t;
        while (s.length() > 0) {
            int i = 0;
            while (i < s.length() && Character.isWhitespace(s.charAt(i)))
                i++;
            if (i > 0)
                tokens.add(new Token(TokenType.WS, " "));
            s = s.substring(i);
            t = TokenType.matchString(s, in_directive);
            if (t == null)
                return;
            if (t.type == TokenType.CPP_COMMENT) {
                tokens.add(new Token(TokenType.WS, " "));
                return;
            }
            if (t.type == TokenType.C_COMMENT) {
                in_c_comment = true;
                eatLine(s.substring(2));
                return;
            }
            tokens.add(t);
            s = s.substring(t.value.length());
        }
        tokens.add(new Token(TokenType.NEWLINE, "\n"));

    }

    Stream<Token> getTokens() {
        process();
        return tokens.stream();
    }
}
