package global.sample;
import global.Database.Connect;
import global.Modules.Bookings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportBookings {
    @FXML
    private TableView<Bookings> bookingsTableView;
    @FXML
    private TableColumn<Bookings, String> Booking_ID;
    @FXML
    private TableColumn<Bookings, String> Start_date;
    @FXML
    private TableColumn<Bookings, String> End_date;


//a new object of Connect
    private Connect _connect = new Connect();

    @FXML
    public void initialize() throws SQLException {
        //to initialize the method below listBookings()
        listBookings();
    }

    private void listBookings() throws SQLException {
        ObservableList<Bookings> list = getBookingslist();
        Booking_ID.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Booking_ID"));
        Start_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Start_date"));
        End_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("End_date"));



        bookingsTableView.setItems(list);
    }

    private ObservableList<Bookings> getBookingslist() throws SQLException {
        //observablelist is used to allow listeners to track changes when they occur
        ObservableList<Bookings> bookingsObservableList = FXCollections.observableArrayList();
        //bookQuery is of type String and is given the SQL statement as its value
        String bookQuery = "SELECT * FROM \"Bookings\" ";
        //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
        // using the sqlExecute method
        ResultSet rs = _connect.sqlExecute(bookQuery);
        Bookings bookings;
        //the .next() method within the while loop continues to return the next token
        // as long as it matches the specified pattern which in this case is the value of rs identified previously
        while (rs.next()) {
            bookings = new Bookings(rs.getString("Booking_ID"), rs.getString("Start_date"), rs.getString("End_date"));
            bookingsObservableList.add(bookings);
        }
        return bookingsObservableList;

    }

}
