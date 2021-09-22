package global.sample;
import global.Database.Connect;
import global.Modules.Receipts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.TableView;
public class ReportReceipt {

        @FXML
        private TableView<Receipts> ReceiptTable;
        @FXML
        private TableColumn<Receipts, String> Receipt_date;
        @FXML
        private TableColumn<Receipts, String> Booking_ID;
        @FXML
        private TableColumn<Receipts, String> Receipt_ID;
        @FXML
        private TextField filter;

        //_connect is a new object of Connect
        private Connect _connect = new Connect();

        @FXML
        void initialize() throws SQLException {
            listReceipts();
        }

        public ObservableList<Receipts> getReceiptslist() throws SQLException {
            //observablelist is used to allow listeners to track changes when they occur

            ObservableList<Receipts> receiptsObservableList = FXCollections.observableArrayList();

            //Filteredlists allow user to obtain the row required in a more efficient way

            FilteredList<Receipts>filteredData=new FilteredList<>(receiptsObservableList,b->true);
            filter.textProperty().addListener((observable,oldValue,newValue)->{
                filteredData.setPredicate(Receipt ->{
                    if (newValue==null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter=newValue.toLowerCase();
                    if (Receipt.getBooking_ID().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                        return true;
                    }else if (Receipt.getReceipt_ID().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                        return true;
                    }else return false;
                });
            });
            SortedList<Receipts>sortedData=new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(ReceiptTable.comparatorProperty());
            ReceiptTable.setItems(sortedData);
            //myQuery is of type String and is given the SQL statement as its value
            String myQuery = "SELECT * FROM \"Receipts\" ";
            //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
            // using the sqlExecute method
            ResultSet rs = _connect.sqlExecute(myQuery);
            Receipts receipts;
            //the .next() method within the while loop continues to return the next token
            // as long as it matches the specified pattern which in this case is the value of rs identified previously
            while (rs.next()) {
                receipts = new Receipts(rs.getString("Receipt_ID"), rs.getString("Booking_ID"),
                        rs.getString("Receipt_date"));
                receiptsObservableList.add(receipts);

            }
            return receiptsObservableList;
        }
        @FXML

        public void listReceipts() throws SQLException {

            ObservableList<Receipts> list = getReceiptslist();
            Receipt_date.setCellValueFactory(new PropertyValueFactory<Receipts, String>("Receipt_date"));
            Booking_ID.setCellValueFactory(new PropertyValueFactory<Receipts, String>("Booking_ID"));
            Receipt_ID.setCellValueFactory(new PropertyValueFactory<Receipts, String>("Receipt_ID"));
            ReceiptTable.setItems(list);
        }

}
