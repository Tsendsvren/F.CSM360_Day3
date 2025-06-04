public class CourierAccount {
    private String name;
    private String phoneNumber;
    private String deliveryMode; 

    public CourierAccount(String name, String phoneNumber, String deliveryMode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryMode = deliveryMode;
    }

 
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    @Override
    public String toString() {
        return "CourierAccount{name='" + name + "', phone='" + phoneNumber + "', mode='" + deliveryMode + "'}";
    }
}
