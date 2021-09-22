package global.sample;
import global.Database.Connect;
import global.Modules.Services;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServiceManage {

    @FXML
    private TableView<Services> tblview;
    @FXML
    private TableColumn<Services, String> Service_price;
    @FXML
    private TableColumn<Services, String> ServiceType;
    @FXML
    private TableColumn<Services, String> Service_ID;
    @FXML
    private TextField NewServiceID;
    @FXML
    private  TextField NewServiceType;
    @FXML
    private TextField NewServicePrice;
    @FXML
    private  Button back5;
    @FXML
    private Connect _connect = new Connect();
    @FXML
    void initialize() throws SQLException {
        listServices();
        setCellValueFromTableToTextField();
    }
    @FXML
    protected void AddNewService(ActionEvent event) {
       ObservableList<Services> data= tblview.getItems();
       data.add(new Services(NewServiceID.getText(), NewServiceType.getText(),NewServicePrice.getText()));
        NewServiceID.setText("");
        NewServiceType.setText("");
        NewServicePrice.setText("");

    }

    public ObservableList<Services> getServiceslist() throws SQLException {
        //observablelist is used to allow listeners to track changes when they occur
        ObservableList<Services> servicesObservableList = FXCollections.observableArrayList();
        String myQuery = "SELECT * FROM \"Services\" ";
        //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
        // using the sqlExecute method
        ResultSet rs = _connect.sqlExecute(myQuery);
        Services services;
        while (rs.next()) {
            //the .next() method within the while loop continues to return the next token
            // as long as it matches the specified pattern which in this case is the value of rs identified previously
            services = new Services(rs.getString("Service_ID"), rs.getString("ServiceType"),
                    rs.getString("Service_price"));
            servicesObservableList.add(services);
        }
        return servicesObservableList;
    }
    @FXML

    public void listServices() throws SQLException {
            ObservableList<Services> list = getServiceslist();
            Service_price.setCellValueFactory(new PropertyValueFactory<Services, String>("Service_price"));
            ServiceType.setCellValueFactory(new PropertyValueFactory<Services, String>("ServiceType"));
            Service_ID.setCellValueFactory(new PropertyValueFactory<Services, String>("Service_ID"));
            tblview.setItems(list);
        }
        @FXML
        private void DeleteRowFromTable(ActionEvent event) {
            //the DeleteRowFromTable method is used to remove selected row
            //the getSelectionModel() method is an abstract class used by UI controls used to maintain selection
            //the .removeAll() method is used to remove all the elements from the list contained in a specific collection
            tblview.getItems().removeAll(tblview.getSelectionModel().getSelectedItems());
        }
        private void setCellValueFromTableToTextField(){
            tblview.setOnMouseClicked(e -> {
                Services sl = tblview.getItems().get(tblview.getSelectionModel().getSelectedIndex());
                NewServiceID.setText(sl.getService_ID());
                NewServiceType.setText(sl.getServiceType());
                NewServicePrice.setText(sl.getService_price());

            });

        }

    public void MBack(ActionEvent event) {
        //allows customer to return to previous window
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagerPage.fxml"));
            Parent Back = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Admin Page");
            stage.setScene(new Scene(Back));
            stage.show();
            Stage stage3 = (Stage) back5.getScene().getWindow();
            stage3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


