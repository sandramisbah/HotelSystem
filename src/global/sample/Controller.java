package global.sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class Controller {
    @FXML
    private Button close1;
    @FXML
    private Button close2;
    @FXML


    public void CustomerWind(ActionEvent event) {
        //CustomerWind method loads the specified fxml file when Customer Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerPage.fxml"));
            Parent CustomerWind = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Customer Page");
            stage.setScene(new Scene(CustomerWind));
            stage.show();
            Stage stage1 = (Stage) close1.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void ManagerWind(ActionEvent event) {
        //ManagerWind method loads the specified fxml file when Customer Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent ManagerWind = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Management Login");
            stage.setScene(new Scene(ManagerWind));
            stage.show();
            Stage stage2 = (Stage) close2.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}



