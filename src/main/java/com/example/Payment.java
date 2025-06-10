package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Payment {
    static final int PRICE_PER_M3 = 190000;
    static final int PRICE_PER_KG = 2000;
    static final int PRICE_PER_KM = 2500;

    private double weight;
    private double volume;
    private double distance;
    private DeliveryType deliveryType;

    private static final Logger logger = LogManager.getLogger(Payment.class);

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
        logger.debug("Payment class-д обьект үүсгэж байна: item={}, deliveryType={}, customer={}",
                item.getName(), delivery.getDeliveryType(), customer.getFullName());

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
            logger.info("Жин > 200 кг, эзэлхүүнээр тооцож байна: {} м3 * {} = {}", volume, PRICE_PER_M3, costVolume);
        } else {
            costVolume = 0;
            costWeight = (int) (weight * PRICE_PER_KG);
            logger.info("Жин <= 200 кг, жингээр тооцож байна: {} кг * {} = {}", weight, PRICE_PER_KG, costWeight);
        }

        costDistance = (int) (distance * PRICE_PER_KM);
        costDeliveryType = deliveryType.getPrice();
        costVehicle = vehicleType.getPrice();

        totalCost = costVolume + costWeight + costDistance + costDeliveryType + costVehicle;

        logger.info("Төлбөрийн нийт дүн тооцогдлоо: {}", totalCost);
    }

    public void printInvoice() {
        logger.info("Нэхэмжлэх хэвлэж байна...");

        logger.info("\n========== Хүргэлтийн Баримт ==========");
        logger.info(" Захиалагч: {}", customer.getFullName());
        logger.info("   Утас: {}", customer.getPhone());
        logger.info("   Имэйл: {}", customer.getEmail());

        logger.info("\n Хаяг:");
        logger.info("   Хүргэлтийн хаяг: {}", location.getAddress());
        logger.info("   Орц: {}", location.getEntrance());
        logger.info("   Орцны дугаар: {}", location.getApartment());

        logger.info("\n Илгээгч:");
        logger.info("   Нэр: {}", location.getSenderName());
        logger.info("   Утас: {}", location.getSenderPhone());
        logger.info("   Имэйл: {}", location.getSenderEmail());

        logger.info("\nХүлээн авагч:");
        logger.info("   Нэр: {}", location.getReceiverName());
        logger.info("   Утас: {}", location.getReceiverPhone());
        logger.info("   Имэйл: {}", location.getReceiverEmail());

        logger.info("\n Бараа:");
        logger.info("   Нэр: {}", item.getName());
        logger.info("   Анхааруулга: {}", item.getWarning().isEmpty() ? "Байхгүй" : item.getWarning());
        logger.info("   Хэмжээ: {} м3 × {}₮ = {}₮", volume, PRICE_PER_M3, costVolume);
        logger.info("   Жин: {} кг × {}₮ = {}₮", weight, PRICE_PER_KG, costWeight);
        logger.info("   Зай: {} км × {}₮ = {}₮", distance, PRICE_PER_KM, costDistance);

        logger.info("\nХүргэлтийн мэдээлэл:");
        logger.info("   Хүргэлтийн төрөл: {} = {}₮", deliveryType.toString(), costDeliveryType);
        logger.info("   Тээврийн хэрэгсэл: {} = {}₮", vehicleType.toString(), costVehicle);

        logger.info("\n Хүргэлтийн ажилтан:");
        logger.info("   Нэр: {}", delivery.getDeliveryWorkerName());
        logger.info("   Утас: {}", delivery.getDeliveryWorkerPhone());
        logger.info("   Имэйл: {}", delivery.getDeliveryWorkerEmail());

        logger.info("\nТөлбөр:");
        logger.info("   Нийт төлбөр: {}₮", totalCost);
        logger.info("   Төлбөр төлөгч: {}", paymentPayer != null ? paymentPayer.toString() : "Тодорхойгүй");

        logger.info(" Хүргэлтийн төлөв: {}", delivery.getStatus());
        logger.info("========================================");
    }

    public int getTotalCost() {
        return totalCost;
    }
}
