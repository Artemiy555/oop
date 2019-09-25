package lessons16;

import java.util.*;
import java.util.concurrent.*;

public class ABQApp {
    public static void main(String[] args) {
        BlockingQueue<String> drop = new ArrayBlockingQueue(1, true);
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}

class Producer implements Runnable {
    private BlockingQueue<String> drop;
    List<String> messages = Arrays.asList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7");

    public Producer(BlockingQueue<String> d) {
        this.drop = d;
    }

    public void run() {
        try {
            for (String s : messages) {
                drop.put(s);
                System.out.println("I've put "+ s);
                Thread.sleep(1000);
            }
            drop.put("DONE");
        } catch (InterruptedException intEx) {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> drop;

    public Consumer(BlockingQueue<String> d) {
        this.drop = d;
    }

    public void run() {
        try {
            String msg = null;
            while (!((msg = drop.take()).equals("DONE"))) {
                System.out.println("I've just read");
                System.out.println(msg);
            }
        } catch (InterruptedException intEx) {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }
}