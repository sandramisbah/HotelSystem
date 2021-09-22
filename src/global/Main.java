package global;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Stage represents a window in JavaFX application
        //When application starts, a root Stage object is created
        //This object is passed to the start method and represents the primary window
        Parent root = FXMLLoader.load(getClass().getResource("sample/sample.fxml"));
        //sets the text to be displayed on the header of the scene
        primaryStage.setTitle("Hotel Anglia");
        //sets the measurements of the scene
        primaryStage.setScene(new Scene(root, 450, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //The Launch method is used to launch the JavaFX runtime
        //it detects from which class it has been called

        launch(args);

    }
}

