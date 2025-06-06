package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testTotalCostCalculation() {
        Item item = new Item("Хөргөгч", 2.5, 250, 20, "Анхаарах зүйл");
        Delivery delivery = new Delivery(DeliveryType.EXPRESS, VehicleType.MOVING_TRUCK);
        Customer customer = new Customer("Ганболд", "ganbold@example.com", "9999-8888");
        LocationInfo location = new LocationInfo("Дулаан", "Хүйтэн", PaymentPayer.RECEIVER);

        Payment payment = new Payment(item, delivery, customer, location);

        // Тооцоолол:
        // Volume: 2.5 × 190000 = 475000
        // Weight: 250 > 200 → жин тооцохгүй
        // Distance: 20 × 2500 = 50000
        // DeliveryType (EXPRESS): 15000
        // VehicleType (MOVING_TRUCK): 50000
        // Total = 475000 + 50000 + 15000 + 50000 = 590000

        assertEquals(590000, payment.getTotalCost());
    }

    @Test
    public void testPrintInvoice() {
        Item item = new Item("Хөргөгч", 2.5, 250, 20, "Анхаарах зүйл");
        Delivery delivery = new Delivery(DeliveryType.EXPRESS, VehicleType.MOVING_TRUCK);
        Customer customer = new Customer("Ганболд", "ganbold@example.com", "9999-8888");
        LocationInfo location = new LocationInfo("Дулаан", "Хүйтэн", PaymentPayer.RECEIVER);

        Payment payment = new Payment(item, delivery, customer, location);
        payment.printInvoice(); // Console-д хэвлэх зориулалттай
    }
}
