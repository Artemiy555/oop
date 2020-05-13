package StavrLine;

public class LineClass implements lineAlgorithms {


    private FiniteAutomata finite = new FiniteAutomata();

    private Boyer boy = new Boyer();

    private Turbo tur = new Turbo();

    @Override
    public void finiteAutomata(char[] txt,char[] pat) {
        finite.finiteAutomata(txt,pat);
    }

    @Override
    public void boyer(char[] txt,char[] pat) {
        boy.boyer(txt,pat);
    }

    @Override
    public void turbo(char[] txt,char[] pat) {
        tur.turbo(txt,pat);
    }

}
