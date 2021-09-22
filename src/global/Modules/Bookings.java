package global.Modules;
public class Bookings {
    String Booking_ID; //Booking_ID is of type String
    String Start_date; //Start_date is of type String
    String End_date;   //End_date is of type String


    public Bookings(String Booking_ID, String Start_date, String End_date) {
        //populating objects in constructor
        this.Booking_ID = Booking_ID;
        this.Start_date = Start_date;
        this.End_date = End_date;


    }

//getters and setters for class Bookings

    public String getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(String booking_ID) {
        Booking_ID = booking_ID;
    }

    public String getStart_date() {
        return Start_date;
    }

    public void setStart_date(String start_date) {
        Start_date = start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String end_date) {
        End_date = end_date;
    }



}