package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.integration.NoItemIDFoundException;
import se.kth.iv1350.pos.model.SaleDTO;


public class ControllerTest {
    private Controller instance;

    @BeforeEach
    public void setUp() {
        instance = new Controller();
    }
    
    @Test
    public void testCreateNewSaleCreatesTheSaleInstance() {
        boolean saleCreated = instance.createNewSale();
        assertNotNull(saleCreated, "Sale was not created");
    }

    @Test
    public void testEnterItemFetchesCorrectSaleInfo() throws NoItemIDFoundException{
        instance.createNewSale();
        int itemID = 1;
        int itemQuantity = 1;
        SaleDTO saleInfo = instance.enterItem(itemID, itemQuantity);
        
        assertNotNull(saleInfo, "Item was not entered");
    }

    @Test
    public void testEnterPaymentReturnsCorrectChange() {
        instance.createNewSale();
        double paidAmount = 10;
        double change = instance.enterPayment(paidAmount);
        assertEquals(10, change, "Payment was not entered");
    }

    @Test
    public void testEndSaleEndsTheSaleInstance() {
        instance.createNewSale();
        double expResult = 0;
        double result = instance.endSale(0);
        assertEquals(expResult, result, "Sale was not ended");
    }
    
    @Test
    public void testPrintPrintsTheReceipt() {
        instance.createNewSale();
        boolean receiptPrinted = instance.print();
        assertTrue(receiptPrinted, "Receipt was not printed");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}