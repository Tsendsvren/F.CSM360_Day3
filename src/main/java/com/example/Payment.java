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
    private PaymentPayer paymentPayer;

    public Payment(Item item, Delivery delivery, Customer customer, LocationInfo location, PaymentPayer paymentPayer) {
        this.item = item;
        this.delivery = delivery;
        this.customer = customer;
        this.location = location;
        this.paymentPayer = paymentPayer;

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
        System.out.println(" Захиалагч: " + customer.getFullName());
        System.out.println("   Утас: " + customer.getPhone());
        System.out.println("   Имэйл: " + customer.getEmail());

        System.out.println("\n Хаяг:");
        System.out.println("   Хүргэлтийн хаяг: " + location.getAddress());
        System.out.println("   Орц: " + location.getEntrance());
        System.out.println("   Орцны дугаар: " + location.getApartment());

        System.out.println("\n Илгээгч:");
        System.out.println("   Нэр: " + location.getSenderName());
        System.out.println("   Утас: " + location.getSenderPhone());
        System.out.println("   Имэйл: " + location.getSenderEmail());

        System.out.println("\nХүлээн авагч:");
        System.out.println("   Нэр: " + location.getReceiverName());
        System.out.println("   Утас: " + location.getReceiverPhone());
        System.out.println("   Имэйл: " + location.getReceiverEmail());

        System.out.println("\n Бараа:");
        System.out.println("   Нэр: " + item.getName());
        System.out.println("   Анхааруулга: " + (item.getWarning().isEmpty() ? "Байхгүй" : item.getWarning()));
        System.out.println("   Хэмжээ: " + volume + " м3 × " + PRICE_PER_M3 + "₮ = " + costVolume + "₮");
        System.out.println("   Жин: " + weight + " кг × " + PRICE_PER_KG + "₮ = " + costWeight + "₮");
        System.out.println("   Зай: " + distance + " км × " + PRICE_PER_KM + "₮ = " + costDistance + "₮");

        System.out.println("\nХүргэлтийн мэдээлэл:");
        System.out.println("   Хүргэлтийн төрөл: " + deliveryType.toString() + " = " + costDeliveryType + "₮");
        System.out.println("   Тээврийн хэрэгсэл: " + vehicleType.toString() + " = " + costVehicle + "₮");

        System.out.println("\n Хүргэлтийн ажилтан:");
        System.out.println("   Нэр: " + delivery.getDeliveryWorkerName());
        System.out.println("   Утас: " + delivery.getDeliveryWorkerPhone());
        System.out.println("   Имэйл: " + delivery.getDeliveryWorkerEmail());

        System.out.println("\nТөлбөр:");
        System.out.println("   Нийт төлбөр: " + totalCost + "₮");
        System.out.println("   Төлбөр төлөгч: " + (paymentPayer != null ? paymentPayer.toString() : "Тодорхойгүй"));

        System.out.println(" Хүргэлтийн төлөв: " + delivery.getStatus());
        System.out.println("========================================");
    }

    public int getTotalCost() {
        return totalCost;
    }
}
