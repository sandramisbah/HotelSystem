package global.sample;
import global.Database.Connect;
import global.Modules.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRooms {
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

        //_connect is a new object of Connect
        private Connect _connect = new Connect();

        @FXML
        void initialize() throws SQLException {
            listRooms();

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




        }




