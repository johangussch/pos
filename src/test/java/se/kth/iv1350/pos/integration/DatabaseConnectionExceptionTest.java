package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionExceptionTest {
    private InventorySystem inventorySystem;
    
    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
    }

    @Test
    public void testConnectionToNonExistingDatabase(){
        assertThrows(DatabaseConnectionException.class, () -> {
            inventorySystem.fetchStoreItems();
        });
    }

    @AfterEach
    public void tearDown() {
        inventorySystem = null;
    }
}