package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class DeliveryTest {

    // Delivery Class Tests
    @ParameterizedTest
    @EnumSource(DeliveryType.class)
    public void testDeliveryInitializationWithAllTypes(DeliveryType type) {
        for (VehicleType vehicle : VehicleType.values()) {
            Delivery delivery = new Delivery(type, vehicle);

            assertEquals(type, delivery.getDeliveryType());
            assertEquals(vehicle, delivery.getVehicleType());
            assertEquals(DeliveryStatus.ORDER_PLACED, delivery.getStatus());
            assertEquals(vehicle.getDeliveryWorkerName(), delivery.getDeliveryWorkerName());
            assertEquals(vehicle.getDeliveryWorkerPhone(), delivery.getDeliveryWorkerPhone());
            assertEquals(vehicle.getDeliveryWorkerEmail(), delivery.getDeliveryWorkerEmail());
        }
    }

    @Test
    public void testNullParametersInConstructor() {
        assertThrows(NullPointerException.class, () -> new Delivery(null, null));
        assertThrows(NullPointerException.class, () -> new Delivery(DeliveryType.STANDARD, null));
        assertThrows(NullPointerException.class, () -> new Delivery(null, VehicleType.MOTORCYCLE));
    }

    @ParameterizedTest
    @EnumSource(DeliveryStatus.class)
    public void testAllStatusChanges(DeliveryStatus status) {
        Delivery delivery = new Delivery(DeliveryType.STANDARD, VehicleType.BICYCLE);
        delivery.setStatus(status);
        assertEquals(status, delivery.getStatus());
    }

    // VehicleType Enum Tests
    @ParameterizedTest
    @EnumSource(VehicleType.class)
    public void testVehicleTypeProperties(VehicleType vehicle) {
        assertNotNull(vehicle.getDeliveryWorkerName());
        assertNotNull(vehicle.getDeliveryWorkerPhone());
        assertNotNull(vehicle.getDeliveryWorkerEmail());
        assertTrue(vehicle.getPrice() > 0);
    }

    @Test
    public void testVehicleTypeToString() {
        assertEquals("Мотоцикль", VehicleType.MOTORCYCLE.toString());
        assertEquals("Унадаг дугуй", VehicleType.BICYCLE.toString());
        assertEquals("Машин", VehicleType.CAR.toString());
        assertEquals("Ачааны жижиг машин", VehicleType.SMALL_TRUCK.toString());
        assertEquals("Нүүлгэлтийн машин", VehicleType.MOVING_TRUCK.toString());
    }

    @Test
    public void testDeliveryTypeToString() {
        assertEquals("Стандарт", DeliveryType.STANDARD.toString());
        assertEquals("Хурдан", DeliveryType.EXPRESS.toString());
    }

    @ParameterizedTest
    @MethodSource("vehiclePriceProvider")
    public void testVehiclePricing(VehicleType vehicle, int expectedPrice) {
        assertEquals(expectedPrice, vehicle.getPrice());
    }

    private static Stream<Object[]> vehiclePriceProvider() {
        return Stream.of(
                new Object[] { VehicleType.MOTORCYCLE, 5000 },
                new Object[] { VehicleType.BICYCLE, 6500 },
                new Object[] { VehicleType.CAR, 10000 },
                new Object[] { VehicleType.SMALL_TRUCK, 20000 },
                new Object[] { VehicleType.MOVING_TRUCK, 50000 });
    }

    // DeliveryType Enum Tests
    @Test
    public void testDeliveryTypePricing() {
        assertEquals(5000, DeliveryType.STANDARD.getPrice());
        assertEquals(15000, DeliveryType.EXPRESS.getPrice());
    }

    // Integration Tests
    @Test
    public void testDeliveryCostCalculation() {
        Delivery standardDelivery = new Delivery(DeliveryType.STANDARD, VehicleType.CAR);
        int expectedStandardCost = DeliveryType.STANDARD.getPrice() + VehicleType.CAR.getPrice();
        // Assuming you have a getTotalPrice() method in Delivery class
        // assertEquals(expectedStandardCost, standardDelivery.getTotalPrice());

        Delivery expressDelivery = new Delivery(DeliveryType.EXPRESS, VehicleType.MOTORCYCLE);
        int expectedExpressCost = DeliveryType.EXPRESS.getPrice() + VehicleType.MOTORCYCLE.getPrice();
        // assertEquals(expectedExpressCost, expressDelivery.getTotalPrice());
    }
}