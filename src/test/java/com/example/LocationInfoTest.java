package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LocationInfoTest {

    @Test
    public void testGetters() {
        // Arrange - объект үүсгэх
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

        // Act & Assert - getter-үүдийг шалгах
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
}
