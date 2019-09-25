package lessons3;

public class MarkerRun {
    public static void main(String[] args) {

        Marker m1 = new Marker("Buromax","black", 10,65);

        Marker m2 = new Marker("Buromax","red", 12,60);
        Marker m3 = new Marker();
        m1.printInfo();
        System.out.println();
        m2.printInfo();
        System.out.println();
        m3.printInfo();
        

    }
}