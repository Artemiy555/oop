package StavrLine;

public class MainLine {

    public static void main(String[] args) {
     LineClass line = new LineClass();
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        line.finiteAutomata(pat,txt);
        line.boyer(pat,txt);
        line.turbo(pat,txt);
    }
}
