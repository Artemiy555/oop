package JavaFx.Lessons1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileWriter;


public class MainController {

    @FXML
    private TextField fildLogin;

    @FXML
    private TextField fildPassword;

    @FXML
    private TextField fildPasswordConfilm;
    FileWriter nFile = null;
    @FXML
    private void registerOnClisk() throws Exception{


        if(fildPassword.getText().equals(fildPasswordConfilm.getText())) {

           // PrintModel.print(fildLogin.getText(), fildPassword.getText(), fildPasswordConfilm.getText());

        }else System.out.println("неправильный ввод пароля");

try {

    String login = fildLogin.getText();
    String pass = fildPassword.getText();

    nFile = new FileWriter("C:/Users/Artemiy/oop/src/JavaFx/Lessons1/text1.txt",true);

    nFile.write("Логин:"  + login + "\nПароль: " + pass+"\n");

    nFile.close();

}catch (Exception e){System.out.println("сломал");}

        System.exit(0);
    }

    @FXML
    private void cancelOnClisk() {

    System.exit(0);

    }


}
