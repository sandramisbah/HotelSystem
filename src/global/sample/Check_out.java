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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check_out {
        @FXML
        private TableView<Bookings> CheckOutTableView;
        @FXML
        private TableColumn<Bookings, String> Booking_ID;
        @FXML
        private TableColumn<Bookings, String> Start_date;
        @FXML
        private TableColumn<Bookings, String> End_date;
        @FXML
        private Label CheckOut;
        @FXML
        private Button back3;

        @FXML

        private Connect _connect = new Connect();

        @FXML
        // The initialize() method is used to initialize a variable on the same statement that the variable is declared insn
        public void initialize() throws SQLException {
            listBookings();
        }

        private void listBookings() throws SQLException {
            ObservableList<Bookings> list = getBookingslist();
            Booking_ID.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Booking_ID"));
            Start_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Start_date"));
            End_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("End_date"));



            CheckOutTableView.setItems(list);
        }

        private ObservableList<Bookings> getBookingslist() throws SQLException {
            //observablelist is used to allow listeners to track changes when they occur
            ObservableList<Bookings> OutObservableList = FXCollections.observableArrayList();
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
                OutObservableList.add(bookings);
            }
            return OutObservableList;
            //this method returns the value of the Observablelist


        }


    public void CheckOut(ActionEvent event) {
            //CheckOut method displays a text to the user confirming that check out process was successful
            CheckOut.setText("Check out Successful !");
    }

    public void MBack(ActionEvent event) {
        //Mback method allows the customer to return to the previous page

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagerPage.fxml"));
            Parent Back = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin Page");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage3 = (Stage) back3.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

