package JavaFx.Lessons3.model;

import JavaFx.Lessons3.domain.Contact;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model {

    private static final String FILE_NAME = "C:\\Users\\Artemiy\\oop\\resources\\datasource\\contact.dat";

    public static void save(List<Contact> contacts){
        try {

        FileWriter fw = new FileWriter(FILE_NAME);

        for ( Contact contact : contacts){
            fw.append(contact.getName())
                    .append(contact.getSurname())
                    .append(contact.getPhone())
                    .append(contact.toString())
                    .append("\r\n");
        }


        fw.flush();
        fw.close();

        }catch (Exception e){
            System.out.println("Сломал");
        }

    }
    public static List<Contact> open(){
        try {

            FileReader fr = new FileReader(FILE_NAME);
            List<Contact> contacts = new ArrayList<>();
            Scanner scanner = new Scanner(fr);

            while (scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(" ");
                Contact contact = new Contact(data[0], data[1], data[2], data[3] );
                contacts.add(contact);
                return contacts;
            }

        }catch (Exception e){
            System.out.println("Сломал");
        }


        return null;

    }



}
