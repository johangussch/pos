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

    
    @Test
    void testFetchNonExistingItem(){
        int itemID = 1;
        assertThrows(NoItemIDFoundException.class, () -> {
            instance.fetchItem(itemID);
        });
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}