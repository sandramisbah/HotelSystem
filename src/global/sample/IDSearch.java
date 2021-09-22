package global.sample;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import global.Database.Connect;
import global.Modules.Bookings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class IDSearch {
    @FXML
    private TableView<Bookings> CustomerTableView;
    @FXML
    private TableColumn<Bookings, String> Booking_ID;
    @FXML
    private TableColumn<Bookings, String> Start_date;
    @FXML
    private TableColumn<Bookings, String> End_date;
    @FXML
    private TextField search;
    @FXML
    private Button back9;
    @FXML
    //creates a new object of Connect
    private Connect _connect = new Connect();

    @FXML
    void initialize() throws SQLException {
        listCustomers();
    }

    private void listCustomers() throws SQLException {
        ObservableList<Bookings> list = getCustomerlist();
        Booking_ID.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Booking_ID"));
        Start_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("Start_date"));
        End_date.setCellValueFactory(new PropertyValueFactory<Bookings, String>("End_date"));


        CustomerTableView.setItems(list);
    }


    @FXML
    private ObservableList<Bookings> getCustomerlist() throws SQLException {
        ObservableList<Bookings> customerObservableList = FXCollections.observableArrayList();
      //Filteredlists allow user to obtain the Booking required in a more efficient way
        FilteredList<Bookings> filteredData = new FilteredList<>(customerObservableList, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Bookings -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Bookings.getBooking_ID().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Bookings.getStart_date().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else return false;
            });
        });
        SortedList<Bookings> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(CustomerTableView.comparatorProperty());
        CustomerTableView.setItems(sortedData);

        //myQuery is of type String and is given the SQL statement as its value
        String customerQuery = "SELECT * FROM \"Bookings\"";
        //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
        // using the sqlExecute method
        ResultSet rs = _connect.sqlExecute(customerQuery);
        Bookings bookings;
        //the .next() method within the while loop continues to return the next token
        // as long as it matches the specified pattern which in this case is the value of rs identified previously
        while (rs.next()) {
            bookings = new Bookings(rs.getString("Booking_ID"), rs.getString("Start_date"), rs.getString("End_date"));
            customerObservableList.add(bookings);
        }

        return customerObservableList;
    }
    public void CancelBooking(ActionEvent event){
        //allows user to cancel an existing booking
            CustomerTableView.getItems().removeAll(CustomerTableView.getSelectionModel().getSelectedItems());
            
    }

    public void CBack(ActionEvent event) {
        //allows user to go back to previous page
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("CustomerPage.fxml"));
            Parent ModifyBooking= (Parent) fxmlLoader.load();
            Stage stage= new Stage();
            stage.setTitle("Customer Page");
            stage.setScene(new Scene(ModifyBooking));
            stage.show();
            Stage stage1 = (Stage) back9.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




