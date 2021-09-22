package global.sample;
import global.Database.Connect;
import global.Modules.Services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportServices {
    @FXML
    private TableView<Services> tblview;
    @FXML
    private TableColumn<Services, String> Service_price;
    @FXML
    private TableColumn<Services, String> ServiceType;
    @FXML
    private TableColumn<Services, String> Service_ID;
    @FXML
    private Connect _connect = new Connect();
    @FXML
    void initialize() throws SQLException {
        listServices();
    }

    public ObservableList<Services> getServiceslist() throws SQLException {

        ObservableList<Services> servicesObservableList = FXCollections.observableArrayList();
        //myQuery is of type String and is given the SQL statement as its value
        String myQuery = "SELECT * FROM \"Services\" ";
        //rs is of type ResultSet, it connects to the database using _connect and executes the SQL query stored in bookQuery
        // using the sqlExecute method
        ResultSet rs = _connect.sqlExecute(myQuery);
        Services services;
        //the .next() method within the while loop continues to return the next token
        // as long as it matches the specified pattern which in this case is the value of rs identified previously
        while (rs.next()) {
            services = new Services(rs.getString("Service_ID"), rs.getString("ServiceType"),
                    rs.getString("Service_price"));
            servicesObservableList.add(services);
        }
        return servicesObservableList;
    }
    @FXML

    public void listServices() throws SQLException {
        //Observable list is used to enable listeners to track changes when they occur
        ObservableList<Services> list = getServiceslist();
        Service_price.setCellValueFactory(new PropertyValueFactory<Services, String>("Service_price"));
        ServiceType.setCellValueFactory(new PropertyValueFactory<Services, String>("ServiceType"));
        Service_ID.setCellValueFactory(new PropertyValueFactory<Services, String>("Service_ID"));
        tblview.setItems(list);
    }

    }
