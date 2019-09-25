package JavaFx.FilleReader.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class NewController {


    FileReader fis = null;
    String text = null;


    @FXML
    private TextField urlFille;


    @FXML
    private TextArea textFille;


    @FXML
    private void createFille() {
        if (urlFille.getText() != null) {
            String abc = urlFille.getText();
            System.out.println(abc);
            File file = new File(urlFille.getText());
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            textFille.setText("Press open to save for\n" + urlFille.getText());

        } else textFille.setText("Еnter URL!\n");

    }


    @FXML
    private void openFille() {

        if (urlFille.getText() != null) {
            try {

                //  char arr[] = null;

                int i = 0;

                String b = "";

                try {


                    fis = new FileReader(urlFille.getText());

                    if (fis.read() != 0) {
                        while ((i = fis.read()) != -1) {
                            b += (char) i;


                        }
                        textFille.setText(b);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else textFille.setText("Введите URL");

    }


    @FXML
    private void saveFille() {

        try {

            FileWriter save = new FileWriter(urlFille.getText(), true);
            save.write(" new:  \n" + textFille.getText() + "\n");
            save.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


