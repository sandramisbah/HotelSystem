package global.sample;
import global.Database.Connect;
import global.Modules.Bookings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check_in {
    @FXML
    private TableView<Bookings> CheckInTableView;
    @FXML
    private TableColumn<Bookings, String> Booking_ID;
    @FXML
    private TableColumn<Bookings, String> Start_date;
    @FXML
    private TableColumn<Bookings, String> End_date;
    @FXML
    private Label CheckIn;
    @FXML
    private Button back2;

    @FXML
    public ComboBox AvailableRooms;
    //AvailableRooms is a comboBox
    //data is a new object of array string and contains an array of all room types in the hotel
    String[] data = new String[]{"Single Room", "Double Room", "Executive-Suite", "Presidential-Suit"};

    private Connect _connect = new Connect();

    @FXML
    // The initialize() method is used to initialize a variable on the same statement that the variable is declared in
    public void initialize() throws SQLException {
        AvailableRooms.getItems().clear();
        //.addAll(data) method is used to add all data into the combo box named AvailableRooms
        AvailableRooms.getItems().addAll(data);
        listBookings();
    }

    private void listBookings() throws SQLException {
        ObservableList<Bookings> list = getBookingslist();
        Booking_ID.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Booking_ID"));
        Start_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Start_date"));
        End_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("End_date"));
        CheckInTableView.setItems(list);
    }

    private ObservableList<Bookings> getBookingslist() throws SQLException {
        //observablelist is used to allow listeners to track changes when they occur
        ObservableList<Bookings> checkObservableList = FXCollections.observableArrayList();
        //checkQuery is of type string and is assigned the SQL statement
        String checkQuery = "SELECT * FROM \"Bookings\" ";
        //rs is of type ResultSet, it connects to database using _connect
        //sqlExecute method is used to execute the value of checkQuery which is the SQL statement
        ResultSet rs = _connect.sqlExecute(checkQuery);
        Bookings bookings;
        while (rs.next()) {
            //the .next() method within the while loop continues to return the next token
            // as long as it matches the specified pattern which in this case is the value of rs identified previously
            bookings = new Bookings(rs.getString("Booking_ID"), rs.getString("Start_date"), rs.getString("End_date"));
            checkObservableList.add(bookings);
        }
        return checkObservableList;
        //this method returns the value of the Observablelist

    }


    public void CancelBooking(ActionEvent event) {
        //the CancelBooking method is used to remove selected
        //the getSelectionModel() method is an abstract class used by UI controls used to maintain selection
        //the .removeAll() method is used to remove all the elements from the list contained in a specific collection
        CheckInTableView.getItems().removeAll(CheckInTableView.getSelectionModel().getSelectedItems());
    }


    public void CheckIn(ActionEvent event) {
        //used to display a text to user confirming that check in is successful
        CheckIn.setText("Check in complete!");

    }

    public void BackManage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagerPage.fxml"));
            Parent Back = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin Page");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage3 = (Stage) back2.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
