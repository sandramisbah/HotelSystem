package global.sample;
import global.Database.Connect;
import global.Modules.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class RoomManage {
    @FXML
    private TableView<Rooms> roomsTableView;
    @FXML
    private TableColumn<Rooms, String> Room_ID;
    @FXML
    private TableColumn<Rooms, String> RoomType;
    @FXML
    private TableColumn<Rooms, Integer> RoomQuantity;
    @FXML
    private TableColumn<Rooms, String> Room_price;
    @FXML
    private Button back4;
    @FXML
             //four combo boxes are assigned room type titles
            //room1/room2/room3 and room4 are new objects of array strings and contain an array of all room numbers in the hotel
    ComboBox SingleRooms;
    String[] room1 = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    @FXML
    ComboBox DoubleRooms;
    String[] room2 = new String[]{" ", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "46", "47", "48", "49", "50", "51"};
    @FXML
    ComboBox ExcecutiveSuite;
    String[] room3 = new String[]{" ", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61"};
    @FXML
    ComboBox PresidentalSuite;
    String[] room4 = new String[]{" ", "62", "63", "64", "65", "66"};

    //_connect is a new object of Connect
    private Connect _connect = new Connect();

    @FXML
    void initialize() throws SQLException {
        listRooms();
        SingleRooms.getItems().clear();
        SingleRooms.getItems().addAll(room1);
        DoubleRooms.getItems().clear();
        DoubleRooms.getItems().addAll(room2);
        ExcecutiveSuite.getItems().clear();
        ExcecutiveSuite.getItems().addAll(room3);
        PresidentalSuite.getItems().clear();
        PresidentalSuite.getItems().addAll(room4);
    }


    private void listRooms() throws SQLException {
        ObservableList<Rooms> list = getRoomslist();
        Room_price.setCellValueFactory(new PropertyValueFactory<Rooms, String>("Room_price"));
        RoomType.setCellValueFactory(new PropertyValueFactory<Rooms, String>("RoomType"));
        Room_ID.setCellValueFactory(new PropertyValueFactory<Rooms, String>("Room_ID"));
        RoomQuantity.setCellValueFactory(new PropertyValueFactory<Rooms, Integer>("RoomQuantity"));
        roomsTableView.setItems(list);
    }

    public ObservableList<Rooms> getRoomslist() throws SQLException {
        //observablelist is used to allow listeners to track changes when they occur
        ObservableList<Rooms> roomsObservableList = FXCollections.observableArrayList();
        //roomQuery is of type String and is given the SQL statement as its value
        String roomQuery = "SELECT * FROM \"Rooms\" ";
        //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
        // using the sqlExecute method
        ResultSet rs = _connect.sqlExecute(roomQuery);
        Rooms rooms;
        //the .next() method within the while loop continues to return the next token
        // as long as it matches the specified pattern which in this case is the value of rs identified previously
        while (rs.next()) {
            rooms = new Rooms(rs.getString("Room_ID"), rs.getString("RoomType"), rs.getString("Room_price"), rs.getInt("RoomQuantity"));
            roomsObservableList.add(rooms);
        }
        return roomsObservableList;

    }

    public void Mback(ActionEvent event) {
        //allows user to go back to previous window
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagerPage.fxml"));
            Parent Back = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin Page");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage3 = (Stage) back4.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
