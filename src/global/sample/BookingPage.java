package global.sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BookingPage {
    @FXML
    public ComboBox RoomType;
    //RoomType is a comboBox
    //data is a new object of array string and contains an array of all room types in the hotel
    String[] data = new String[]{"Single Room", "Double Room", "Executive-Suite", "Presidential-Suit"};

    //SimpleDateFormat is used to parse the date from a java string
    // myFormat is new new object of SimpleDateFormat
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

    @FXML
    private Label inDateLabel;
    @FXML
    private Label outDateLabel;
    @FXML
    private Label daysLabel;
    @FXML
    private DatePicker inDate;
    @FXML
    private DatePicker outDate;
    @FXML
    private Label Confirmation;
    @FXML


// The initialize() method is used to initialize a variable on the same statement that the variable is declared in
    public void initialize() throws SQLException {

        RoomType.getItems().clear();

        RoomType.getItems().addAll(data);

        inDate.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                inDateLabel.setText(inDate.getValue().toString());
            }
        });
        outDate.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                outDateLabel.setText(outDate.getValue().toString());

            }
        });

    }

    public void sortDate(ActionEvent event) {

        //sortDate method is used to calculate the amount of days the customer is staying
        //based on the selections made in the datepicker

        try {
            //identifies the value that the user selected in the first date selection
            //.toString() method is used to convert it to type string

            Date dateBefore = myFormat.parse(inDate.getValue().toString());

            //identifies the value that the user selected in the first date selection

            Date dateAfter = myFormat.parse(outDate.getValue().toString());

            //difference is of type long which makes it have a min value of 0
            //the value assigned to difference is obtained through the deduction of
            //the dateBefore which is the customer's first selection from the dateAfter
            // which is the customer's second selection

            long difference = dateAfter.getTime() - dateBefore.getTime();

            //daysbetween is of type float
            //the value assigned to daysbetween is the value of difference divided 1000*60*24

            float daysbetween = (difference / (1000 * 60 * 60 * 24));

            //the .setText method is used to set a value to the days label
            //which is value of daysbetween converted to type String instead of float

            daysLabel.setText(Float.toString(daysbetween));

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void confirmbook(ActionEvent event) {
        //confirmbook method uses an if statement to check if customer has left blank spaces(some of the required values are null)
        //when creating a booking which are essential in order to complete the booking
        //if the condition is true then an alert statement is displayed to the user
        //otherwise a text appears stating that booking has been confirmed

        if (RoomType.getValue()== null || outDateLabel==null || inDateLabel==null)  {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Booking inComplete");
            alert.setContentText("Please complete selection");
            alert.showAndWait();
        } else
        Confirmation.setText("Booking confirmed");

    }


    }




