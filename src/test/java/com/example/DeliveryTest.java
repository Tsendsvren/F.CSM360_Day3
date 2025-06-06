package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeliveryTest {

    @Test
    public void testDeliveryInitialization() {
        Delivery delivery = new Delivery(DeliveryType.EXPRESS, VehicleType.SMALL_TRUCK);

        assertEquals(DeliveryType.EXPRESS, delivery.getDeliveryType());
    }

    @Test
    public void testSetAndGetStatus() {
        Delivery delivery = new Delivery(DeliveryType.STANDARD, VehicleType.MOTORCYCLE);
        delivery.setStatus(DeliveryStatus.OUT_FOR_DELIVERY);

        assertEquals(DeliveryStatus.OUT_FOR_DELIVERY, delivery.getStatus());
    }
}
