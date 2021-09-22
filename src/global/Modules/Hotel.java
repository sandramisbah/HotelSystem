package global.Modules;
public class Hotel {
    String Hotel_ID;//Hotel_ID is of type String
    String Hotel_title;//Hotel_title is of type String
    String HotelEmail;//HotelEmail is of type String
    String AdminUsername;//AdminUsername is of type String
    String AdminPassword;//AdminPassword is of type String
    String HotelAddress;//HotelAddress is of type String
    String Contact_number;//Contact_number is of type String to allow usage of symbols such as (+) sign

    public Hotel(String Hotel_ID, String Hotel_title, String HotelEmail, String AdminUsername, String AdminPassword, String HotelAddress, String Contact_number) {
        //populating objects within the Hotel's constructor
        this.Hotel_ID=Hotel_ID;
        this.Hotel_title=Hotel_title;
        this.AdminPassword=AdminPassword;
        this.AdminUsername=AdminUsername;
        this.HotelAddress=HotelAddress;
        this.HotelEmail=HotelEmail;
        this.Contact_number=Contact_number;
    }


    //setters and getters for class Hotel

    public String getHotel_ID() {
        return Hotel_ID;
    }

    public void setHotel_ID(String hotel_ID) {
        Hotel_ID = hotel_ID;
    }

    public String getHotel_title() {
        return Hotel_title;
    }

    public void setHotel_title(String hotel_title) {
        Hotel_title = hotel_title;
    }

    public String getHotelEmail() {
        return HotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        HotelEmail = hotelEmail;
    }

    public String getAdminUsername() {
        return AdminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        AdminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        HotelAddress = hotelAddress;
    }

    public String getContact_number() {
        return Contact_number;
    }

    public void setContact_number(String contact_number) {
        Contact_number = contact_number;
    }
}
