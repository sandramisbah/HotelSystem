package global.sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomerPage {
    @FXML
    private Button back8;
    @FXML
    void NewBook(ActionEvent event){
        //NewBook method loads the specified fxml file when NewBooking Button is clicked
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("BookingPage.fxml"));
            Parent NewBooking= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Booking Page");
            stage.setScene(new Scene(NewBooking));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findID(ActionEvent event) {
        //findID method loads the specified fxml file when ModifyBooking Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("IDSearch.fxml"));
            Parent ModifyBooking= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Booking Search");
            stage.setScene(new Scene(ModifyBooking));
            stage.show();
            Stage stage1 = (Stage) back8.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void CBack(ActionEvent event) {
        //allows the user to return to previous page
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent ModifyBooking= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Hotel Anglia");
            stage.setScene(new Scene(ModifyBooking));
            stage.show();
            Stage stage1 = (Stage) back8.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

