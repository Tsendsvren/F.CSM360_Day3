package com.example;

public class Payment {
    static final int PRICE_PER_M3 = 190000;
    static final int PRICE_PER_KG = 2000;
    static final int PRICE_PER_KM = 2500;

    private double weight;
    private double volume;
    private double distance;
    private DeliveryType deliveryType;
    private VehicleType vehicleType;
    private Item item;
    private Delivery delivery;
    private Customer customer;
    private LocationInfo location;

    private int costVolume;
    private int costWeight;
    private int costDistance;
    private int costDeliveryType;
    private int costVehicle;
    private int totalCost;

    public Payment(Item item, Delivery delivery, Customer customer, LocationInfo location) {
        this.item = item;
        this.delivery = delivery;
        this.customer = customer;
        this.location = location;

        this.weight = item.getWeight();
        this.volume = item.getVolume();
        this.distance = item.getDistance();
        this.deliveryType = delivery.getDeliveryType();
        this.vehicleType = delivery.getVehicleType();

        if (weight > 200) {
            costVolume = (int) (volume * PRICE_PER_M3);
            costWeight = 0;
        } else {
            costVolume = 0;
            costWeight = (int) (weight * PRICE_PER_KG);
        }

        costDistance = (int) (distance * PRICE_PER_KM);
        costDeliveryType = deliveryType.getPrice();
        costVehicle = vehicleType.getPrice();

        totalCost = costVolume + costWeight + costDistance + costDeliveryType + costVehicle;
    }

    public void printInvoice() {
        System.out.println("\n========== Хүргэлтийн Баримт ==========");
        System.out.println("Захиалагч: " + customer.getFullName());
        System.out.println("Хүргүүлэгч: " + location.getSenderName());
        System.out.println("Хүлээн авагч: " + location.getReceiverName());
        System.out.println("Бараа: " + item.getName());
        if (costVolume > 0) {
            System.out.println("Барааны хэмжээ: " + volume + " м3 × " + PRICE_PER_M3 + "₮ = " + costVolume + "₮");
        }
        if (costWeight > 0) {
            System.out.println("Барааны жин: " + weight + " кг × " + PRICE_PER_KG + "₮ = " + costWeight + "₮");
        }
        System.out.println("Хүргэлтийн зай: " + distance + " км × " + PRICE_PER_KM + "₮ = " + costDistance + "₮");
        System.out.println("Хүргэлтийн төрөл: " + deliveryType.toString() + " = " + costDeliveryType + "₮");
        System.out.println("Тээврийн хэрэгсэл: " + vehicleType.toString() + " = " + costVehicle + "₮");
        System.out.println("Нийт төлбөр: " + totalCost + "₮");
        System.out.println("Хүргэлтийн ажилтан: " + delivery.getDeliveryWorkerName());
        System.out.println("=====================================");
    }

    public int getTotalCost() {
        return totalCost;
    }
}
