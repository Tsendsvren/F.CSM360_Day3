public class CourierAccount {
    private String name;           // Хүргэгчийн нэр
    private String phoneNumber;    // Утасны дугаар
    private String deliveryMode;   // Хүргэлтийн горим (мотоцикл, машин гэх мэт)

    public CourierAccount(String name, String phoneNumber, String deliveryMode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryMode = deliveryMode;
    }

    // Getters
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
        return "CourierAccount{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deliveryMode='" + deliveryMode + '\'' +
                '}';
    }