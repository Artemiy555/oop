package JavaFx.FilleReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxReader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fille Reader");
        Parent view = FXMLLoader.load(
                getClass().getResource("/view/Reader/main.fxml")
        );
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

}
