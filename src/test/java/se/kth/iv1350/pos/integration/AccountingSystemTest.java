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
    public void testIfRecordSoldItemActuallyWorksOrIfItDoesntWorkDependingOnWhatMoodItIsAtToday() {
        List<Item> boughtItems = new ArrayList<>();
        boughtItems.add(new Item(1, null, 1));
        instance.recordSoldItem(boughtItems);
        assertNotNull(instance.soldItems, "Item was not recorded");
    }

    @Test
    public void testIfUpdateBalanceActuallyWorksOrIfItDoesntWorkDependingOnWhatMoodItIsAtToday() {
        double amount = 100;
        instance.updateBalance(amount);
        assertEquals(100, instance.balance, "Balance was not updated");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
