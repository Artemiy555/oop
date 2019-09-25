package JavaFx.Lessons3.model;

import JavaFx.Lessons3.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class TestDataSourse {

    public static void main(String[] agrs){

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("safsaf","dsgs","dgasd","fasfas"));


        Model.save(contacts);

        List<Contact> contactsFromFile = Model.open();

            for (Contact contact : contactsFromFile){

                System.out.println(contact);
            }


    }
}
