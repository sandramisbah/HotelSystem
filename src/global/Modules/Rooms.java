package global.Modules;
public class Rooms {
    public String Room_ID;//Room_ID is of type String
    public String RoomType;//RoomType is of type String
    public String Room_price;//Room_price is of type String
    public int RoomQuantity;//RoomQuantity is of type int

    public Rooms(String Room_ID, String RoomType, String Room_price, int RoomQuantity) {
        //populating objects within Rooms constructor
        this.Room_ID=Room_ID;
        this.RoomType=RoomType;
        this.Room_price=Room_price;
        this.RoomQuantity=RoomQuantity;

    }
//getters and setters for class Rooms

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String room_ID) {
        Room_ID = room_ID;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getRoom_price() {
        return Room_price;
    }

    public void setRoom_price(String room_price) {
        Room_price = room_price;
    }

    public int getRoomQuantity() {
        return RoomQuantity;
    }

    public void setRoomQuantity(int roomQuantity) {
        RoomQuantity = roomQuantity;
    }


}


