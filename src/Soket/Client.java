package Soket;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
    private static final String host = "localhost";
    private static final int port = 9999;
    private Socket socket;

    public Client() {}

    @Override
    public void run() {
        init();
    }

    private void init() {
        String[] files = new String[] { "C:\\new\\1.txt", "C:\\new\\5.txt", "C:\\new\\tst.txt" };

        try {
            long start = System.currentTimeMillis();
            socket = new Socket(host, port);
            for ( int i = 0; i < files.length; i++ ) {
                SocketUtil.transmit(socket, new File(files[i]));
            }

            long finish = System.currentTimeMillis();
            long timeConsumedMillis = finish - start;
            double time = (double)timeConsumedMillis;
            System.out.println(time/1000+"сек");

            System.out.println("Работает!");
        } catch ( UnknownHostException e ) {
            System.out.println("краш1");
            e.printStackTrace(System.out);
        } catch ( IOException e ) {
            System.out.println("краш2");
            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        new Thread(new Client()).start();
    }
}