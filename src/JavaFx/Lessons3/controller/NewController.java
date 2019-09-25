package JavaFx.Lessons3.controller;

import JavaFx.Lessons3.domain.Contact;
import JavaFx.Lessons3.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class NewController {

    private ObservableList<Contact> contacts;



    @FXML private VBox main;

    private void initialize(){
        contacts = FXCollections.observableArrayList(Model.open());


    }

    @FXML
    private void addDialogOnClick() throws IOException {
        Stage dialogNewContact = new Stage();

            GridPane dlg = FXMLLoader.load(
                    getClass().getResource("/view/Lessons3/modal/dialog.fxml"));

            dialogNewContact.setTitle("New Contact - Dialog");
            dialogNewContact.setResizable(false); //запрет на изменение

            dialogNewContact.initModality(Modality.WINDOW_MODAL); //Тип Диалогового окна Модальный
            dialogNewContact.initOwner(main.getScene().getWindow()); //Ссылка на главное окно

            dialogNewContact.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                }

            });
            dialogNewContact.setScene(new Scene(dlg));

            dialogNewContact.showAndWait();//ожидание пользывателя
    }

    @FXML
    private void closeDialogOnClick(){
        System.exit(0);
    }
}
