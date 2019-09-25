package Soket;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 9999;
    private static ServerSocket ss;
    private Socket socket;

    public Server() {
        init();
    }

    private void init() {
        String[] files = new String[] { "1.txt", "5.txt", "tst.txt" };


        if ( files == null ) {
            System.exit(1);
        }

        try {
            ss = new ServerSocket(port);
            for ( ; ; ) {
                socket = ss.accept();
                for ( int i = 0; i < files.length; i++ ) {
                    SocketUtil.receive(socket, new File(files[i]));
                }
                if ( socket.isConnected() ) {
                    socket.close();
                }
            }
        } catch ( IOException e ) {
            System.out.println("краш3");

            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}