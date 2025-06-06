package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    public void testPaymentCalculation() {
        Customer customer = new Customer("Батаа", "99999999", "bataa@mail.mn");
        Item item = new Item("Ноутбук", 0.03, 2.0, 10.0, "Эмзэг");
        Delivery delivery = new Delivery(DeliveryType.STANDARD, VehicleType.CAR);
        LocationInfo location = new LocationInfo("СБД, 1-р хороо", "3", "45", "Анхаа", "88888888", "anhaa@mail.mn",
                "Батаа", "99999999", "bataa@mail.mn");

        Payment payment = new Payment(item, delivery, customer, location);

        double total = payment.getTotalCost();
        assertTrue(total > 0); // JUnit-ийн assertTrue ашиглаж байна
    }
}
