package lessons14;

public class Tack2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("main start");
        Thread myThread = new Thread(new My());
        myThread.start();
        System.out.println("main ended!");
    }
}

class My implements Runnable {
    public void run() {
        System.out.println("My start");
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": Iter " + (i + 1));
        }
        System.out.println("My ended");
    }
}
