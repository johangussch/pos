package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item instance;

    @BeforeEach
    public void setUp() {
        instance = new Item(1, null, 1);
    }

    @Test
    public void testFetchItemID() {
        int expResult = 1;
        int result = instance.fetchItemID();
        assertEquals(expResult, result, "Item ID was not fetched");
    }

    @Test
    public void testFetchItemDTO() {
        ItemDTO expResult = null;
        ItemDTO result = instance.fetchItemDTO();
        assertEquals(expResult, result, "Item DTO was not fetched");
    }

    @Test
    public void testFetchItemQuantity() {
        int expResult = 1;
        int result = instance.fetchItemQuantity();
        assertEquals(expResult, result, "Item quantity was not fetched");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
