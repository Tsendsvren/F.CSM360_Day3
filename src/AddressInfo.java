public class AddressInfo {
    private String receiverName;
    private String receiverPhone;
    private String entrance;
    private String apartment;

    public AddressInfo(String name, String phone, String entrance, String apartment) {
        this.receiverName = name;
        this.receiverPhone = phone;
        this.entrance = entrance;
        this.apartment = apartment;
    }

    public String getFullAddress() {
        return entrance + ", " + apartment;
    }
}
