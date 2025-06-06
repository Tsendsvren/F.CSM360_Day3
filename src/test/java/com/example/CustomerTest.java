package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerInitialization() {
        Customer customer = new Customer("Батаа", "99999999", "bataa@mail.mn");

        assertEquals("Батаа", customer.getFullName());
        assertEquals("99999999", customer.getPhone());
        assertEquals("bataa@mail.mn", customer.getEmail());
    }

    @Test
    public void testEmptyConstructorParameters() {
        Customer customer = new Customer("", "", "");

        assertEquals("", customer.getFullName());
        assertEquals("", customer.getPhone());
        assertEquals("", customer.getEmail());
    }

    @Test
    public void testSpecialCharactersInName() {
        Customer customer = new Customer("Бат-Амгалан", "12345678", "test@example.com");
        assertEquals("Бат-Амгалан", customer.getFullName());
    }

    @Test
    public void testLongPhoneNumber() {
        Customer customer = new Customer("Test", "123456789012345", "test@example.com");
        assertEquals("123456789012345", customer.getPhone());
    }

    @Test
    public void testEmailFormat() {
        Customer customer = new Customer("Test", "12345678", "test.email+123@sub.example.mn");
        assertEquals("test.email+123@sub.example.mn", customer.getEmail());
    }
}