package lessons16.Drink;
public class ThreadUtils {

    private ThreadUtils() {}

    public static void println(Object msg) {
        System.out.println(Thread.currentThread() + ": " + msg);
    }

    /**
     * @return has thread been interrupted?
     */
    public static boolean sleep(long millis) {
        try {
            Thread.sleep(millis);
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return true;
        }
    }
}
