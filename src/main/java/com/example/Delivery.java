package com.example;

public class Delivery {
    private DeliveryType deliveryType;
    private VehicleType vehicleType;
    private String deliveryWorkerName;
    private String deliveryWorkerPhone;
    private String deliveryWorkerEmail;
    private DeliveryStatus status;

    public Delivery(DeliveryType deliveryType, VehicleType vehicleType) {
        this.deliveryType = deliveryType;
        this.vehicleType = vehicleType;
        this.deliveryWorkerName = vehicleType.getDeliveryWorkerName();
        this.deliveryWorkerPhone = vehicleType.getDeliveryWorkerPhone();
        this.deliveryWorkerEmail = vehicleType.getDeliveryWorkerEmail();
        this.status = DeliveryStatus.ORDER_PLACED;
    }

    // Getters
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
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

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
