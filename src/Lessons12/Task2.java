package Lessons12;
import java.io.*;
public class Task2 {
    public static void main(String[] args) {

        try (ObjectOutputStream out = new ObjectOutputStream(

                new FileOutputStream("data.ser"))) {

            Integer A = 55;
            Float F = new Float(5.5f);

            out.writeObject(A);
            out.writeObject(F);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream out = new ObjectInputStream(
                new FileInputStream("data.ser"))) {

            Integer A = (Integer) out.readObject();
            Float F = (Float) out.readObject();
            System.out.println(A + " " + F);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
