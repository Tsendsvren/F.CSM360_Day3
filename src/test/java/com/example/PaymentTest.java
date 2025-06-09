package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testTotalCostCalculation() {
        Item item = new Item("Хөргөгч", 2.5, 250, 20, "Анхаарах зүйл");
        Delivery delivery = new Delivery(DeliveryType.EXPRESS, VehicleType.MOVING_TRUCK);
        Customer customer = new Customer("Ганболд", "9999-8888", "ganbold@example.com");
        LocationInfo location = new LocationInfo(
                "Улаанбаатар, Сүхбаатар дүүрэг",
                "Орц 1",
                "Давхар 3, 301 тоот",
                "Батбаяр",
                "99009900",
                "batbayar@example.com",
                "Наран",
                "99008877",
                "naran@example.com");

        Payment payment = new Payment(item, delivery, customer, location, PaymentPayer.RECEIVER);

        assertEquals(590000, payment.getTotalCost());
    }

    @Test
    public void testWeightCostCalculation() {
        Item item = new Item("Зөөврийн компьютер", 0.2, 150, 10, "");
        Delivery delivery = new Delivery(DeliveryType.STANDARD, VehicleType.MOTORCYCLE);
        Customer customer = new Customer("Нараа", "8888-7777", "naraa@example.com");
        LocationInfo location = new LocationInfo(
                "Улаанбаатар, Баянзүрх дүүрэг",
                "Орц 2",
                "Давхар 1, 102 тоот",
                "Бат-Эрдэнэ",
                "99112233",
                "baterdene@example.com",
                "Намуун",
                "99009911",
                "namuun@example.com");

        Payment payment = new Payment(item, delivery, customer, location, PaymentPayer.SENDER);

        assertEquals(335000, payment.getTotalCost());
    }

    @Test
    public void testPrintInvoice() {
        Item item = new Item("Хөргөгч", 2.5, 250, 20,
                "Хөргөгчний шингэн асгарах магадлалтай тул босоогоор нь зөөвөрлөх.");
        Delivery delivery = new Delivery(DeliveryType.EXPRESS, VehicleType.CAR);
        Customer customer = new Customer("Ганболд", "9999-8888", "ganbold@example.com");
        LocationInfo location = new LocationInfo(
                "Улаанбаатар, Сүхбаатар дүүрэг",
                "Орц 1",
                "Давхар 3, 301 тоот",
                "Батбаяр",
                "99009900",
                "batbayar@example.com",
                "Наран",
                "99008877",
                "naran@example.com");

        Payment payment = new Payment(item, delivery, customer, location, PaymentPayer.RECEIVER);
        payment.printInvoice();
    }
}
