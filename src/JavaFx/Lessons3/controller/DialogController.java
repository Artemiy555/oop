package JavaFx.Lessons3.controller;

import JavaFx.Lessons3.domain.Contact;
import JavaFx.Lessons3.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;


public class DialogController {

    @FXML private GridPane dlg;
    @FXML private TextField fname;
    @FXML private TextField fsurname;
    @FXML private TextField fphone;
    @FXML private TextField femail;

    @FXML
    private void enterOnClick(){
        List<Contact> contacts = Model.open();
        Contact contact = new Contact(
                fname.getText().toString(),
                fsurname.getText().toString(),
                fphone.getText().toString(),
                femail.getText().toString()
        );
        contacts.add(contact);
        Model.save(contacts);
        close();
    }



    @FXML
    private void cancelOnClick(){
        close();
    }

    private void close() {
        Stage doalog = (Stage) dlg.getScene().getWindow();
        doalog.getOnCloseRequest();
        doalog.close();
    }

}
