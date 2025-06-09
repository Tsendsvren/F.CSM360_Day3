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
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (senderName == null || senderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender name cannot be empty");
        }
        if (senderEmail == null || !senderEmail.contains("@")) {
            throw new IllegalArgumentException("Sender email is invalid");
        }
        if (receiverName == null || receiverName.trim().isEmpty()) {
            throw new IllegalArgumentException("Receiver name cannot be empty");
        }
        if (receiverEmail == null || !receiverEmail.contains("@")) {
            throw new IllegalArgumentException("Receiver email is invalid");
        }
        // Өөр шаардлагатай шалгалтуудыг нэмж болно

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

    // Хэрэглэгдээгүй конструкторыг устгаж болно эсвэл хэрэгтэй бол бүрэн
    // хэрэгжүүлээрэй
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
