package JavaFx.TestNaPidora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxTestNaPidora extends Application {

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Русская рулетка");
        Parent view = FXMLLoader.load(
                getClass().getResource("/view/TestNaPidora/main.fxml")
        );
        primaryStage.setScene(new Scene(view));
        primaryStage.show();

    }

}
