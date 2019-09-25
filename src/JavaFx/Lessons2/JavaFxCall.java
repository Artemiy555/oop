package JavaFx.Lessons2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxCall extends Application {


    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Калькулятор");
        Parent view = FXMLLoader.load(
                getClass().getResource("/view/Lessons2/main.fxml")
        );
        primaryStage.setScene(new Scene(view));
        primaryStage.show();

    }
}
