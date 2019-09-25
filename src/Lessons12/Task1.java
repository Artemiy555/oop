package Lessons12;
import java.io.*;
public class Task1 {
    public static void main(String[] args) {

        System.out.println("writing ...");
        try {
            DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("dataout.dat")));
            out.writeShort(1200);
            out.writeInt(50000);
            out.writeLong(12345678L);
            out.writeDouble(55.66);
            out.writeBoolean(true);
            out.writeUTF("Hello!!!");
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("reading ...");

        try {
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("dataout.dat")));
            System.out.println("short: " + in.readShort());
            System.out.println("int: " + in.readInt());
            System.out.println("long: " + in.readLong());
            System.out.println("double: " + in.readDouble());
            System.out.println("boolean: " + in.readBoolean());
            System.out.println("String UTF: " + in.readUTF());
            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
