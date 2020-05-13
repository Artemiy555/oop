package StavrLine;

public class MainLine {

    public static void main(String[] args) {
     LineClass line = new LineClass();
        char txt[] = "Buddhism is an Indian religion[14] founded on the teachings of a mendicant and spiritual teacher called \\\"the Buddha\\\" (\\\"the Awakened One\\\", c. 5th to 4th century BCE).[15][16] Early texts have the Buddha's family name as \\\"Gautama\\\" (Pali: Gotama). The details of Buddha's life are mentioned in many Early Buddhist Texts but are inconsistent, and his social background and life details are difficult to prove, the precise dates are uncertain:KBSLABSJLBABABABABBALKSSBLDBALBSLBABABBABABpuiuyhfhiolijydfklho;juyjthjfglhi;oiuyoligukkuli;oufyjdtfkglih;oilufyjfkuih;uoilukyjfklih;ouliukfyuli;o".toCharArray();
        char pat[] = "is".toCharArray();






        line.finiteAutomata(pat,txt);
        System.out.println();
        line.boyer(pat,txt);
        System.out.println();
        line.turbo(pat,txt);
    }
}
