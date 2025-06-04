public class UserAccount {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public UserAccount(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void displayInfo() {
        System.out.println("Нэр: " + getFullName());
        System.out.println("Утас: " + phoneNumber);
        System.out.println("Хаяг: " + address);
    }
}