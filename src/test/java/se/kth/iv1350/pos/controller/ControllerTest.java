package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.integration.DatabaseConnectionException;
import se.kth.iv1350.pos.integration.NoItemIDFoundException;
import se.kth.iv1350.pos.model.SaleDTO;


public class ControllerTest {
    private Controller instance;

    @BeforeEach
    public void setUp() throws DatabaseConnectionException{
        instance = new Controller();
    }
    
    @Test
    public void testCreateNewSaleCreatesTheSaleInstance() throws DatabaseConnectionException{
        boolean saleCreated = instance.createNewSale();
        assertNotNull(saleCreated, "Sale was not created");
    }
    
    @Test
    public void testEnterPaymentReturnsCorrectChange() throws DatabaseConnectionException{
        instance.createNewSale();
        double paidAmount = 10;
        double change = instance.enterPayment(paidAmount);
        assertEquals(10, change, "Payment was not entered");
    }

    @Test
    public void testEndSaleEndsTheSaleInstance() throws DatabaseConnectionException{
        instance.createNewSale();
        double expResult = 0;
        double result = instance.endSale(0);
        assertEquals(expResult, result, "Sale was not ended");
    }
    
    @Test
    public void testPrintPrintsTheReceipt() throws DatabaseConnectionException{
        instance.createNewSale();
        boolean receiptPrinted = instance.print();
        assertTrue(receiptPrinted, "Receipt was not printed");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}