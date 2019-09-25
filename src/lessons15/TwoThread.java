package lessons15;

public class TwoThread {
    public static void main(String args[]) {
        final StringBuffer s = new StringBuffer();
        new Thread() {
            public void run() {
                int i = 0;
                    synchronized (s){
                while (i++ < 3) {
                    s.append("0");
                    try {
                        sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                }}}}.start();

        new Thread() {
            public void run() {
                int j = 0;
                synchronized (s){
                while (j++ < 5) {
                    s.append("1");
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                }}}}.start();
    }
}
