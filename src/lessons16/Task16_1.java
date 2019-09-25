package lessons16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class Task16_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory -> ");
        String dir = sc.next();
        System.out.print("Enter keyword -> ");
        String word = sc.next();
        Counter counter = new Counter(new File(dir), word);
        FutureTask<Integer> task = new FutureTask <Integer> (counter);
        new Thread(task).start();
        try {
            System.out.println(task.get() + " files.");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Counter implements Callable<Integer> {
    private File dir; private String word;
    public Counter(File dir, String word) {
        this.dir = dir;
        this.word = word;
    }
    public boolean search(File ff) {
        try (Scanner sc = new Scanner(new FileInputStream(ff))) {
            boolean flag = false;
            while ( !flag && sc.hasNextLine()) {
                String str = sc.nextLine();
                if (str.contains(word))
                    flag = true;
            }
            return flag;
        } catch (IOException e) { return false; }
    }

    public Integer call() {
        int count = 0;
        try {
            File[] files = dir.listFiles();
            ArrayList<Future<Integer>> result = new ArrayList<>();
            for (File ff : files)
                if (ff.isDirectory()) {
                    Counter counter = new Counter(ff, word);
                    FutureTask<Integer> task = new FutureTask <Integer> (counter);
                    result.add(task);
                    new Thread(task).start();
                }
                else if ( search(ff) )
                    count++;
            for (Future<Integer> rez : result)
                count += rez.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
