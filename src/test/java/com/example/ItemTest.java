package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testItemInitialization() {
        Item item = new Item("Ноутбук", 0.03, 2.0, 5.0, "Эмзэг");

        assertNotNull(item);
        assertEquals("Ноутбук", item.getName());
        assertEquals(0.03, item.getVolume(), 0.001);
        assertEquals(2.0, item.getWeight(), 0.001);
        assertEquals(5.0, item.getDistance(), 0.001);
        assertEquals("Эмзэг", item.getWarning());
    }

    @Test
public void testItemConstructorThrowsExceptionForInvalidInputs() {
    assertThrows(IllegalArgumentException.class, () -> new Item(null, 0.03, 2.0, 5.0, "Warning"));
    assertThrows(IllegalArgumentException.class, () -> new Item("", 0.03, 2.0, 5.0, "Warning"));
    assertThrows(IllegalArgumentException.class, () -> new Item("Ноутбук", -0.01, 2.0, 5.0, "Warning"));
    assertThrows(IllegalArgumentException.class, () -> new Item("Ноутбук", 0.03, -2.0, 5.0, "Warning"));
    assertThrows(IllegalArgumentException.class, () -> new Item("Ноутбук", 0.03, 2.0, -5.0, "Warning"));
}
}