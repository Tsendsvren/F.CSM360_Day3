package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerInitialization() {
        Customer customer = new Customer("Батаа", "99999999", "bataa@mail.mn");

        assertEquals("Батаа", customer.getFullName());
        assertEquals("99999999", customer.getPhone());
        assertEquals("bataa@mail.mn", customer.getEmail());
    }
}
