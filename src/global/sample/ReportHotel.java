package global.sample;
import global.Database.Connect;
import global.Modules.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportHotel {
    @FXML
    private TableView<Hotel> HotelTable;
    @FXML
    private TableColumn<Hotel, String> Hotel_ID;
    @FXML
    private TableColumn<Hotel, String> Hotel_title;
    @FXML
    private TableColumn<Hotel, String> HotelEmail;
    @FXML
    private  TableColumn<Hotel,String> AdminUsername;
    @FXML
    private TableColumn<Hotel,String> AdminPassword;
    @FXML
    private TableColumn<Hotel,String> HotelAddress;
    @FXML
    private TableColumn<Hotel, String> Contact_number;


    //_connect is a new object of Connect

    private Connect _connect = new Connect();


    @FXML
    void initialize() throws SQLException {
        listHotel();


    }


    public ObservableList<Hotel> getHotellist() throws SQLException {

        ObservableList<Hotel> hotelObservableList = FXCollections.observableArrayList();
        //bookQuery is of type String and is given the SQL statement as its value
        String myQuery = "SELECT * FROM \"Hotel\" ";
        //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
        // using the sqlExecute method
        ResultSet rs = _connect.sqlExecute(myQuery);
        Hotel hotel;
        //the .next() method within the while loop continues to return the next token
        // as long as it matches the specified pattern which in this case is the value of rs identified previously
        while (rs.next()) {

            hotel = new Hotel(rs.getString("Hotel_ID"), rs.getString("Hotel_title"),
                    rs.getString("HotelEmail"), rs.getString("AdminUsername"),rs.getString("AdminPassword"), rs.getString("HotelAddress"), rs.getString("Contact_number"));
            hotelObservableList.add(hotel);
        }
        return hotelObservableList;

    }
    @FXML

    public void listHotel() throws SQLException {

        ObservableList<Hotel> list = getHotellist();
        Hotel_ID.setCellValueFactory(new PropertyValueFactory<Hotel, String>("Hotel_ID"));
        Hotel_title.setCellValueFactory(new PropertyValueFactory<Hotel, String>("Hotel_title"));
        HotelEmail.setCellValueFactory(new PropertyValueFactory<Hotel, String>("HotelEmail"));
        HotelAddress.setCellValueFactory(new PropertyValueFactory<Hotel, String>("HotelAddress"));
        AdminUsername.setCellValueFactory(new PropertyValueFactory<Hotel, String>("AdminUsername"));
        AdminPassword.setCellValueFactory(new PropertyValueFactory<Hotel, String>("AdminPassword"));
        Contact_number.setCellValueFactory(new PropertyValueFactory<Hotel,String>("Contact_number"));

        HotelTable.setItems(list);
    }


}

