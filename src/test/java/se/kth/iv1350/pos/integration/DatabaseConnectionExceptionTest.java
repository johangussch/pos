package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionExceptionTest {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    
    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
    }

    @Test
    void testConnectionToNonExistingDatabase(){
        assertThrows(DatabaseConnectionException.class, () -> {
            inventorySystem.(); // ta ta bort alla items i inventory system
            inventorySystem.(); // om den itne funkar så skickar den exception i InventorySystem-filen

            accountingSystem.(); // ta ta bort alla items i accounting system
            accountingSystem.(); // om den itne funkar så skickar den exception i AccountingSystem-filen
        
            // FIXA LIKVÄRDIGA METODER FÖR setMapNull och getMap i båda
        
        });
    }

    @AfterEach
    public void tearDown() {
        inventorySystem = null;
        accountingSystem = null;
    }

}
