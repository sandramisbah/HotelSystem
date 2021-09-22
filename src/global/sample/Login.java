package global.sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Login {
    @FXML
    private Button close1;
    @FXML
    private  Button back;


   @FXML
   //opens management page once user has logged in
   void ManagementOpener(ActionEvent event){
      try{


          FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerPage.fxml"));
          Parent Management= (Parent) fxmlLoader.load();
          Stage stage= new Stage();
          stage.setTitle("Admin Page");
          stage.setScene(new Scene(Management));
          stage.show();
          Stage stage1 = (Stage) close1.getScene().getWindow();
          stage1.close();


      } catch (IOException e) {
          e.printStackTrace();
      }
  }
//allows user to return to previous page
    public void MainBack(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent Back= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Hotel Anglia");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage1 = (Stage) back.getScene().getWindow();
            stage1.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
