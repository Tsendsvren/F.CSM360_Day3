package com.example;

public enum VehicleType {
    MOTORCYCLE(5000, "Намжил", "9999-1111", "namjil@example.com"),
    BICYCLE(6500, "Баатар", "9999-2222", "baatar@example.com"),
    CAR(10000, "Бат", "9999-3333", "bat@example.com"),
    SMALL_TRUCK(20000, "Саран", "9999-4444", "saran@example.com"),
    MOVING_TRUCK(50000, "Долгор", "9999-5555", "dolgor@example.com");

    private final int price;
    private final String deliveryWorkerName;
    private final String deliveryWorkerPhone;
    private final String deliveryWorkerEmail;

    VehicleType(int price, String name, String phone, String email) {
        this.price = price;
        this.deliveryWorkerName = name;
        this.deliveryWorkerPhone = phone;
        this.deliveryWorkerEmail = email;
    }

    public int getPrice() {
        return price;
    }

    public String getDeliveryWorkerName() {
        return deliveryWorkerName;
    }

    public String getDeliveryWorkerPhone() {
        return deliveryWorkerPhone;
    }

    public String getDeliveryWorkerEmail() {
        return deliveryWorkerEmail;
    }

    @Override
    public String toString() {
        switch (this) {
            case MOTORCYCLE:
                return "Мотоцикль";
            case BICYCLE:
                return "Унадаг дугуй";
            case SMALL_TRUCK:
                return "Ачааны жижиг машин";
            case MOVING_TRUCK:
                return "Нүүлгэлтийн машин";
            default:
                return "Машин";
        }
    }
}
