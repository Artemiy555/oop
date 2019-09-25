package JavaFx.Lessons1;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxDemo extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Регистрация");
        Parent view = FXMLLoader.load(
                getClass().getResource("/view/Lessons1/main.fxml")
        );
        primaryStage.setScene(new Scene(view));
        primaryStage.show();

    }
}
