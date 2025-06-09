package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LocationInfoTest {

    @Test
    public void testGetters() {
        LocationInfo location = new LocationInfo(
            "Ulaanbaatar, Sukhbaatar district",
            "Entrance A",
            "Apartment 101",
            "Batbayar",
            "99009900",
            "batbayar@example.com",
            "Naran",
            "99008877",
            "naran@example.com"
        );

        assertEquals("Ulaanbaatar, Sukhbaatar district", location.getAddress());
        assertEquals("Entrance A", location.getEntrance());
        assertEquals("Apartment 101", location.getApartment());
        assertEquals("Batbayar", location.getSenderName());
        assertEquals("99009900", location.getSenderPhone());
        assertEquals("batbayar@example.com", location.getSenderEmail());
        assertEquals("Naran", location.getReceiverName());
        assertEquals("99008877", location.getReceiverPhone());
        assertEquals("naran@example.com", location.getReceiverEmail());
    }

    @Test
    public void testEmptyAddressThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationInfo(
                "",
                "Entrance A",
                "Apartment 101",
                "Batbayar",
                "99009900",
                "batbayar@example.com",
                "Naran",
                "99008877",
                "naran@example.com"
            );
        });
        assertEquals("Address cannot be empty", ex.getMessage());
    }

    @Test
    public void testEmptySenderNameThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationInfo(
                "Ulaanbaatar",
                "Entrance A",
                "Apartment 101",
                "  ",  // хоосон нэр
                "99009900",
                "batbayar@example.com",
                "Naran",
                "99008877",
                "naran@example.com"
            );
        });
        assertEquals("Sender name cannot be empty", ex.getMessage());
    }

    @Test
    public void testInvalidSenderEmailThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationInfo(
                "Ulaanbaatar",
                "Entrance A",
                "Apartment 101",
                "Batbayar",
                "99009900",
                "batbayarexample.com",  // буруу и-мэйл
                "Naran",
                "99008877",
                "naran@example.com"
            );
        });
        assertEquals("Sender email is invalid", ex.getMessage());
    }

    @Test
    public void testEmptyReceiverNameThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationInfo(
                "Ulaanbaatar",
                "Entrance A",
                "Apartment 101",
                "Batbayar",
                "99009900",
                "batbayar@example.com",
                "",  // хоосон нэр
                "99008877",
                "naran@example.com"
            );
        });
        assertEquals("Receiver name cannot be empty", ex.getMessage());
    }

    @Test
    public void testInvalidReceiverEmailThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationInfo(
                "Ulaanbaatar",
                "Entrance A",
                "Apartment 101",
                "Batbayar",
                "99009900",
                "batbayar@example.com",
                "Naran",
                "99008877",
                "naranexample.com"  // буруу и-мэйл
            );
        });
        assertEquals("Receiver email is invalid", ex.getMessage());
    }
}
