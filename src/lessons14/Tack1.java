package lessons14;

public class Tack1 {
    public static void main(String[] args) {
        System.out.println("MainSort start");
        MyTest test = new MyTest();
        test.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MainSort ended!");
    }
}

class MyTest extends Thread  {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(this.getName() + ": ");
            System.out.println("Iter " + (i + 1));
        }
    }
}
