package MembraneComputing.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Membrane");
        Parent view = FXMLLoader.load(
                getClass().getResource("/view/Test/main.fxml")
        );
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

}
