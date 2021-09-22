package global.sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class ManagerPage {
    @FXML
    private Button closeReport;
    @FXML
    private Button closeService;
    @FXML
    private Button closeRoom;
    @FXML
    private Button closeBook;
    @FXML
    private Button closeNew;
    @FXML
    private Button closeIn;
    @FXML
    private  Button closeOut;
    @FXML
    private Button back1;
    @FXML

    public void ReportOpener(ActionEvent event) {
        //ReportOpener method loads the specified fxml file when Report Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReportManage.fxml"));
            Parent Report = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Manage Report");
            stage.setScene(new Scene(Report));
            stage.show();
            Stage stage1 = (Stage) closeReport.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Service(ActionEvent event) {
        //Service method loads the specified fxml file when ManageServices Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ServiceManage.fxml"));
            Parent ManageServices = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Manage Services");
            stage.setScene(new Scene(ManageServices));
            stage.show();
            Stage stage2 = (Stage) closeService.getScene().getWindow();
            stage2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Room(ActionEvent event) {
        //Room method loads the specified fxml file when ManageRooms Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RoomManage.fxml"));
            Parent ManageRooms = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Manage Rooms");
            stage.setScene(new Scene(ManageRooms));
            stage.show();
            Stage stage3 = (Stage) closeRoom.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void checkin(ActionEvent event) {
        //checkin method loads the specified fxml file when Checkin Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Check_in.fxml"));
            Parent Checkin = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Check-in");
            stage.setScene(new Scene(Checkin));
            stage.show();
            Stage stage4 = (Stage) closeIn.getScene().getWindow();
            stage4.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void checkout(ActionEvent event) {
        //checkout method loads the specified fxml file when Checkout Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Check_out.fxml"));
            Parent Checkout = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Check-out");
            stage.setScene(new Scene(Checkout));
            stage.show();
            Stage stage5= (Stage) closeOut.getScene().getWindow();
            stage5.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void BookNew(ActionEvent event) {
        //BookNew method loads the specified fxml file when NewBooking Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookingPage.fxml"));
            Parent NewBooking = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("New Booking");
            stage.setScene(new Scene(NewBooking));
            stage.show();
            Stage stage6 = (Stage) closeNew.getScene().getWindow();
            stage6.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Book(ActionEvent event) {
        //Book method loads the specified fxml file when ManageBookings Button is clicked
        //close() method is used to close the previous scene once this one is opened
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookManage.fxml"));
            Parent ManageBookings = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Manage Bookings");
            stage.setScene(new Scene(ManageBookings));
            stage.show();
            Stage stage7 = (Stage) closeBook.getScene().getWindow();
            stage7.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void LoginBack(ActionEvent event) {
        //allows user to return to previous window
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent Back = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Management Login");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage3 = (Stage) back1.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}