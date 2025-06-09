package com.example;

import java.util.Objects;

public class Delivery {
    private DeliveryType deliveryType;
    private VehicleType vehicleType;
    private String deliveryWorkerName;
    private String deliveryWorkerPhone;
    private String deliveryWorkerEmail;
    private DeliveryStatus status;

    public Delivery(DeliveryType deliveryType, VehicleType vehicleType) {
        this.deliveryType = Objects.requireNonNull(deliveryType, "DeliveryType cannot be null");
        this.vehicleType = Objects.requireNonNull(vehicleType, "VehicleType cannot be null");
        this.deliveryWorkerName = Objects.requireNonNull(vehicleType.getDeliveryWorkerName(),
                "Worker name cannot be null");
        this.deliveryWorkerPhone = Objects.requireNonNull(vehicleType.getDeliveryWorkerPhone(),
                "Worker phone cannot be null");
        this.deliveryWorkerEmail = Objects.requireNonNull(vehicleType.getDeliveryWorkerEmail(),
                "Worker email cannot be null");
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
