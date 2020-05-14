package lessons14;

public class Tack2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Text start");
        Thread myThread = new Thread(new My());
        Thread my = new Thread(new MyTest());
        myThread.start();
        my.start();
        System.out.println("Text ended!");
    }
}

class My implements Runnable {
    public void run() {
        System.out.println("My start");
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name + ": Iter " + (i + 1));
        }
        System.out.println("My ended");
    }

    class MyTest extends Thread  {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.print(this.getName() + ": ");
                System.out.println("Iter " + (i + 1));
            }
        }
    }

}
