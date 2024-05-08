package se.kth.iv1350.pos.model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SaleTest {
    private Sale instance;

    @BeforeEach
    public void setUp() {
        instance = new Sale();
    }

    @Test
    public void testFetchRunningTotalFetchesCorrectRunningTotal() {
        double expResult = 0;
        double result = instance.fetchRunningTotal();
        assertEquals(expResult, result, "Running total was not fetched");
    }

    @Test
    public void testFetchSaleInfoFetchesCorrectSaleInfo() {
        SaleDTO expResult = instance.saleInfo;
        SaleDTO result = instance.fetchSalelnfo();
        assertEquals(expResult, result, "Sale info was not fetched");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

}
