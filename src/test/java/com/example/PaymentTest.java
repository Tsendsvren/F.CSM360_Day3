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
 
        assertEquals(590000, payment.getTotalCost());
    }

    @Test
    public void testWeightCostCalculation() {
        Item item = new Item("Зөөврийн компьютер", 0.2, 150, 10, "");
        Delivery delivery = new Delivery(DeliveryType.STANDARD, VehicleType.MOTORCYCLE);
        Customer customer = new Customer("Нараа", "naraa@example.com", "8888-7777");
        LocationInfo location = new LocationInfo("А", "Б", PaymentPayer.SENDER);
 
        Payment payment = new Payment(item, delivery, customer, location);
 
        assertEquals(335000, payment.getTotalCost());
    }
 
    @Test
    public void testPrintInvoice() {
        Item item = new Item("Хөргөгч", 2.5, 250, 20, "Анхаарах зүйл");
        Delivery delivery = new Delivery(DeliveryType.EXPRESS, VehicleType.CAR);
        Customer customer = new Customer("Ганболд", "ganbold@example.com", "9999-8888");
        LocationInfo location = new LocationInfo("Дулаан", "Хүйтэн", PaymentPayer.RECEIVER);
 
        Payment payment = new Payment(item, delivery, customer, location);
        payment.printInvoice();
    }
}
 
 