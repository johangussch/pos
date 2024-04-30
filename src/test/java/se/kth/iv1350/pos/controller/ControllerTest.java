package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.Item;

import java.util.ArrayList;
import java.util.List;


public class ControllerTest {
    private Controller instance;

    @BeforeEach
    public void setUp() {
        instance = new Controller();
    }
    
    @Test
    public void testCreateNewSale() {
        instance.createNewSale();
        assertNotNull(instance.sale, "Sale was not created");
    }

    @Test
    public void testEnterItem() {
        instance.createNewSale();
        int itemID = 1;
        int itemQuantity = 1;
        instance.enterItem(itemID, itemQuantity);
        assertNotNull(instance.sale, "Item was not entered");
    }

    @Test
    public void testEnterPayment() {
        instance.createNewSale();
        double paidAmount = 10;
        List<Item> boughtItems = new ArrayList<>();
        boughtItems.add(new Item(1, null, 1));
        instance.enterPayment(paidAmount);
        assertNotNull(instance.sale, "Payment was not entered");
    }

    @Test
    public void testEndSale() {
        instance.createNewSale();
        double expResult = 0;
        double result = instance.endSale(0);
        assertEquals(expResult, result, "Sale was not ended");
    }
    
    @Test
    public void testPrint() {
        instance.createNewSale();
        instance.print();
        assertNotNull(instance.sale, "Receipt was not printed");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}