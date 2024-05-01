package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.Item;

import java.util.ArrayList;
import java.util.List;

public class AccountingSystemTest {
    private AccountingSystem instance;

    @BeforeEach
    public void setUp() {
        instance = new AccountingSystem();
    }

    @Test
    public void testRecordSoldItemAddsBoughtsItemToSoldItems() {
        List<Item> soldItems = new ArrayList<>();
        soldItems.add(new Item(1, null, 1));
        instance.recordSoldItem(soldItems);
        assertNotNull(instance.soldItems, "Item was not recorded");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
