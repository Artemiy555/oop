package lessons15;


class Synchro {


    public void writing(String str, int i) {
        try {
            System.out.print(str);
            Thread.sleep((long) (Math.random() * 15));
            System.out.println("->" + i );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SynchroThreads {
    public static void main(String[] args) {
        Synchro s = new Synchro();
        T t1 = new T("First", s);
        T t2 = new T("Second", s);
        t1.start();
        t2.start();
    }
}

class T extends Thread {
    private String str;
    private Synchro s;
    public T(String str, Synchro s) {
        this.str = str;
        this.s = s;
    }
    public void run() {
        for (int i = 0; i < 10; i++)
            s.writing(str, i);
    }}
