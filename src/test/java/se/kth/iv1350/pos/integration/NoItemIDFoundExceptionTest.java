import se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoItemIDFoundExceptionTest {
    private InventorySystem inventorySystem;
    private DbHandler dbHandler;

    @BeforeEach
    void setup() {
        inventorySystem = new InventorySystem();
        dbHandler = new DbHandler(inventorySystem, new ExternalAccounting());
    }

    @AfterEach
    void tearDown() {
        inventorySystem = null;
        dbHandler = null;
    }

    @Test
    void testAddNonExistingItem(){
        Assertions.assertThrows(NoSuchItemIdentifierException.class, () -> {
            dbHandler.getItemDTO(new ItemIdentifier("1001"));
        });
    }
}
