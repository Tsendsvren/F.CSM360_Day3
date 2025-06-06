package com.example;

public class Customer {
    private String fullName;
    private String phone;
    private String email;

    public Customer(String fullName, String phone, String email) {
    this.fullName = fullName;
    this.phone = phone;
    this.email = email;


    this.fullName=fullName;this.phone=phone;this.email=email;

    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
