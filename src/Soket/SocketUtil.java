package Soket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketUtil {
    private static final int size = 1073741824; // 1 gb

    private SocketUtil() {}

    public static void transmit(Socket socket, File file) {
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = new FileInputStream(file);
            byte[] buffer = new byte[size];

            for ( int count = -1; ( count = is.read(buffer) ) != -1; ) {
                os.write(buffer, 0, count);
            }
            os.flush();
            is.close();
        } catch ( IOException e ) {
            System.out.println("краш5");

            e.printStackTrace(System.out);
        }
    }

    public static void receive(Socket socket, File file) {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = new FileOutputStream(file);
            byte[] buffer = new byte[size];

            for ( int count = is.read(buffer), total = count; count != -1; count = is.read(buffer), total += count ) {
                os.write(buffer, 0, count);
               // if ( total == len ) {
                 //   break;
               // }
            }
            os.flush();
            os.close();
        } catch ( IOException e ) {

            System.out.println("краш4");

            e.printStackTrace(System.out);
        }
    }
}
