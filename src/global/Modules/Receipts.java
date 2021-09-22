package global.Modules;

public class Receipts {
    String Receipt_ID;//Receipt_ID is of type String
    String Booking_ID;//Booking_ID is of type String
    String Receipt_date;//Receipt_date is of type String

    public Receipts(String Receipt_ID, String Booking_ID, String Receipt_date) {
        //populating objects within Receipts constructor
        this.Booking_ID = Booking_ID;
        this.Receipt_date = Receipt_date;
        this.Receipt_ID = Receipt_ID;

    }
//getters and setters for class Receipts

    public String getReceipt_ID() {
        return Receipt_ID;
    }

    public void setReceipt_ID(String receipt_ID) {
        Receipt_ID = receipt_ID;
    }

    public String getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(String booking_ID) {
        Booking_ID = booking_ID;
    }

    public String getReceipt_date() {
        return Receipt_date;
    }

    public void setReceipt_date(String receipt_date) {
        Receipt_date = receipt_date;
    }

}