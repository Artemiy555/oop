package JavaFx.Lessons3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxLessons3 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListViev - DEMO");
        primaryStage.setResizable(false);//запрет на изменение

        Parent view = FXMLLoader.load(
                getClass().getResource("/view/Lessons3/main.fxml")
        );

        primaryStage.setScene(new Scene(view));
        primaryStage.show();

    }


}
