package com.example;

public enum DeliveryType {
    STANDARD(5000),
    EXPRESS(15000);

    private final int price;

    DeliveryType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        switch (this) {
            case STANDARD:
                return "Стандарт";
            case EXPRESS:
                return "Хурдан";
            default:
                return "";
        }
    }
}
