package StavrLine;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainLine {

    public static void main(String[] args) {
     LineClass line = new LineClass();

        long start;
        long finish;
        long timeConsumedMillis;
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }

        start = System.currentTimeMillis();

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("30тс: "+timeConsumedMillis);

        char[] txt = new char[256];
        try(FileReader reader = new FileReader("note.txt"))//
        {
            int c;
            while((c = reader.read(txt))>0){

                if(c < 256){
                    txt = Arrays.copyOf(txt, c);
                }
                System.out.print(txt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        char pat[] = "ca".toCharArray();

        line.finiteAutomata(pat,txt);
        System.out.println();
        line.boyer(pat,txt);
        System.out.println();
        line.turbo(pat,txt);


        try(FileWriter writer = new FileWriter("log.txt", false))
        {
            start = System.currentTimeMillis();
            line.finiteAutomata(pat,txt);
            finish = System.currentTimeMillis();
            timeConsumedMillis = finish - start;
            writer.write("Deterministic Finite Automaton algorithm: "+timeConsumedMillis);

            start = System.currentTimeMillis();
            line.boyer(pat,txt);
            finish = System.currentTimeMillis();
            timeConsumedMillis = finish - start;
            writer.write("Tuned Boyer-Moore algorithm: "+timeConsumedMillis);

            start = System.currentTimeMillis();
            line.turbo(pat,txt);
            finish = System.currentTimeMillis();
            timeConsumedMillis = finish - start;
            writer.write("Turbo Reverse Factor algorithm: "+timeConsumedMillis);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        try {
            desktop.open(new File("note.txt"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
