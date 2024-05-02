package se.kth.iv1350.pos.model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SaleDTOTest {
    private SaleDTO instance;

    @BeforeEach
    public void setUp() {
        instance = new SaleDTO("2021-05-20 12:00:00", 1000, 100, null, 1100);
    }

    @Test
    public void testFetchSaleTimeFetchesCorrectSaleTime() {
        String expResult = "2021-05-20 12:00:00";
        String result = instance.fetchSaleTime();
        assertEquals(expResult, result, "Sale time is not the same.");
    }

    @Test
    public void testFetchTotalPriceFetchesCorrectTotalPrice() {
        double expResult = 1000;
        double result = instance.fetchTotalPrice();
        assertEquals(expResult, result, "Total price is not the same.");
    }

    @Test
    public void testFetchTotalVATFetchesCorrectTotalVAT() {
        double expResult = 100;
        double result = instance.fetchTotalVAT();
        assertEquals(expResult, result, "Total VAT is not the same.");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
