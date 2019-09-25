package laba2.controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TestListMap");
        Parent view = FXMLLoader.load(
                getClass().getResource("/view/Laba2/main.fxml")
        );
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

}
