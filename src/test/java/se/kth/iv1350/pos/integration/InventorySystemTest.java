package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.Item;
import java.util.ArrayList;
import java.util.List;

public class InventorySystemTest {
    private InventorySystem instance;

    @BeforeEach
    public void setUp() {
        instance = new InventorySystem();
    }

    @Test
    public void testFetchItemReturnsCorrectItemBasonOnItemID() {
        int itemID = 1;
        Item item = instance.fetchItem(itemID);
        assertNotNull(item, "Item was not fetched");
    }

    @Test
    public void testUpdateQuantityUpdatesStoreItemsWithCorrectItem() {
        int itemID = 1;
        int newQuantity = 5;
        instance.updateQuantity(itemID, newQuantity);
        assertEquals(newQuantity, instance.fetchItem(itemID).fetchItemQuantity(), "Quantity was not updated");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

}
