package com.example;

public class LocationInfo {
    private String address;
    private String entrance;
    private String apartment;
    private String senderName;
    private String senderPhone;
    private String senderEmail;
    private String receiverName;
    private String receiverPhone;
    private String receiverEmail;

    public LocationInfo(String address, String entrance, String apartment,
            String senderName, String senderPhone, String senderEmail,
            String receiverName, String receiverPhone, String receiverEmail) {
        this.address = address;
        this.entrance = entrance;
        this.apartment = apartment;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderEmail = senderEmail;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverEmail = receiverEmail;
    }

    public LocationInfo(String string, String string2, PaymentPayer receiver) {
        // TODO Auto-generated constructor stub
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public String getEntrance() {
        return entrance;
    }

    public String getApartment() {
        return apartment;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }
}
