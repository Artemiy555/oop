package lessons15;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    public static void main(String[] args) {
        MyCounter meter = new MyCounter();
        MyCountThread[] tgs = new MyCountThread[100];
        for (int i = 0; i < 100; i++)
            tgs[i] = new MyCountThread(meter, 100_000);
        for (MyCountThread thread : tgs)
            thread.start();
        try {
            for (MyCountThread thread : tgs)
                thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("int: " + meter.count1 + "\nvolatile: "
                + meter.count2 + "\nAtomic: " + meter.count3);
    }
}

class MyCounter {
    public int count1;
    public volatile int count2;
    public AtomicInteger count3 = new AtomicInteger(0);
}

class MyCountThread extends Thread {
    MyCounter meter;
    int number;

    public MyCountThread(MyCounter m, int n) {
        this.meter = m;
        this.number = n;
    }

    public void run() {
        for (int i = 0; i < number; i++) {
            this.meter.count1++;
            this.meter.count2++;
            this.meter.count3.getAndIncrement();
        }
    }
}
