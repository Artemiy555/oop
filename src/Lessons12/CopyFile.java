package Lessons12;

import java.io.*;
public class CopyFile {
    public static void main(String[] args) throws IOException {

        long before = System.currentTimeMillis();//старт таймера

        int i;
        String fileSource = "c:/vlc-3.0.0-win32.exe";
        String fileDestination = "c:/Users/Artemiy/Downloads/vlc.exe";
        FileInputStream fin = new FileInputStream(fileSource);
        FileOutputStream fout = new FileOutputStream(fileDestination);

        while ((i = fin.read()) != -1) {
            fout.write(i);
        }
        fin.close();
        fout.close();

        long after = System.currentTimeMillis();//Конец таймера

        System.out.println("Time1 = " + (after - before));//Вывод времени 1



        fileDestination = "c:/Users/Artemiy/Downloads/vlc_buff.exe";

        before = System.currentTimeMillis();//старт таймера

        BufferedInputStream brin = null;
        BufferedOutputStream brout = null;

        try {
            int j;
            brin = new BufferedInputStream(new FileInputStream(fileSource));
            brout = new BufferedOutputStream(new FileOutputStream(fileDestination));

            while ((j = brin.read()) != -1) {
                brout.write(j);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (brin != null) brin.close();
            if (brout != null) brout.close();
        }

        after = System.currentTimeMillis();//Конец таймера

        System.out.println("Time2 = " + (after - before));//Вывод времени 2
    }
}