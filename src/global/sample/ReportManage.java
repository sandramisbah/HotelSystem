package global.sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class ReportManage {
    @FXML
    private Button back10;

    public void ReceiptReport(ActionEvent event) {
        //ReceiptReport method loads the specified fxml file when Receipt Report Button is clicked
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ReportReceipt.fxml"));
            Parent Management= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Report");
            stage.setScene(new Scene(Management));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void RoomReport(ActionEvent event) {
        //RoomReport method loads the specified fxml file when RoomReport Button is clicked
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ReportRooms.fxml"));
            Parent Management= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Report");
            stage.setScene(new Scene(Management));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HotelInfo(ActionEvent event) {
        //HotelInfo method loads the specified fxml file when Hotel info Button is clicked
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ReportHotel.fxml"));
            Parent Management= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Report");
            stage.setScene(new Scene(Management));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BookReport(ActionEvent event) {
        //BookReport method loads the specified fxml file when Bookings Report Button is clicked
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ReportBookings.fxml"));
            Parent Management= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Report");
            stage.setScene(new Scene(Management));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ServiceReport(ActionEvent event) {
        //ServiceReport method loads the specified fxml file when Service Report Button is clicked
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ReportServices.fxml"));
            Parent Management= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Report");
            stage.setScene(new Scene(Management));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void BackR(ActionEvent event) {
        //allows customer to go back to previous window
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerPage.fxml"));
            Parent Back= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Admin Page");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage1 = (Stage) back10.getScene().getWindow();
            stage1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
