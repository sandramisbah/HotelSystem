package global.Modules;
public class Services {
    String Service_ID;//Service_ID is of type String
    String ServiceType;//ServiceType is of type String
    String Service_price;//Service_price is of type String

    public Services(String Service_ID, String ServiceType, String Service_price) {
//populating objects within Services constructor
        this.Service_ID = Service_ID;
        this.ServiceType = ServiceType;
        this.Service_price = Service_price;
    }
//getters and setters for class Services

    public String getService_ID() {
        return Service_ID;
    }

    public void setService_ID(String service_ID) {
        Service_ID = service_ID;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getService_price() {
        return Service_price;
    }

    public void setService_price(String service_price) {
        Service_price = service_price;
    }
}

