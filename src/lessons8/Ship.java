package lessons8;

public class Ship {
    private static int x = 20;
    private int y = 10;

    public static class Boat{

        public static void test(){ //nested
        System.out.println(x);
        Ship myship = new Ship();
        System.out.println(myship.y);
        }

    }

}
