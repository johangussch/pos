package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.Item;

public class InventorySystemTest {
    private InventorySystem instance;

    @BeforeEach
    public void setUp() {
        instance = new InventorySystem();
    }

    @Test
    public void testFetchItemReturnsCorrectItemBasonOnItemID() {
        int itemID = 1;
        try {
            Item item = instance.fetchItem(itemID);
            assertNotNull(item, "Item was not fetched");
        } catch (NoItemIDFoundException e) {
            fail("No item ID found exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateQuantityUpdatesStoreItemsWithCorrectItem() throws NoItemIDFoundException {
        int itemID = 1;
        int newQuantity = 5;
        try {
            instance.updateQuantity(itemID, newQuantity);
            assertEquals(newQuantity, instance.fetchItem(itemID).fetchItemQuantity(), "Quantity was not updated");
        } catch (DatabaseConnectionException e) {
            fail("Database connection exception occurred: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}