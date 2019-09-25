package JavaFx.Lessons2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class MainController {

    @FXML
    private TextField wordA;
    @FXML
    private TextField wordB;
    @FXML
    private TextField wordC;
    @FXML
    private void plus() {
        try {
        double a = Integer.parseInt(wordA.getText());
        double b = Integer.parseInt(wordB.getText());
        Double sum = a+b;
        wordC.setText("Cума: "+sum);
        }catch (Exception e){wordC.setText("ТЫ ШО СЛОМАТЬ МЕНЯ РЕШИЛ?!");}


    }
    @FXML
    private void minus() {
        try {


            double a = Integer.parseInt(wordA.getText());
            double b = Integer.parseInt(wordB.getText());
            Double sum = a - b;
            wordC.setText("Разница: " + sum);
        }catch (Exception e){wordC.setText("ТЫ ШО СЛОМАТЬ МЕНЯ РЕШИЛ?!");}
    }
    @FXML
    private void pom() {
        try {
            double a = Integer.parseInt(wordA.getText());
            double b = Integer.parseInt(wordB.getText());
            Double sum = a*b;
        wordC.setText("Умнажение: "+sum);
        }catch (Exception e){
            wordC.setText("ТЫ ШО СЛОМАТЬ МЕНЯ РЕШИЛ?!");
        }

    }
    @FXML
    private void del() {
        try {
            double a = Integer.parseInt(wordA.getText());
            double b = Integer.parseInt(wordB.getText());
        if(b==0)wordC.setText("Ты шо чукча, на на ноль поделить?!");
        else {
            Double sum = a / b;
            wordC.setText("Деление: " + sum);
        }
        }catch (Exception e){wordC.setText("ТЫ ШО СЛОМАТЬ МЕНЯ РЕШИЛ?!");}

    }

}
