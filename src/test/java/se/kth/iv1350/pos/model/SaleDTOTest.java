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
    public void testFetchSaleTime() {
        String expResult = "2021-05-20 12:00:00";
        String result = instance.fetchSaleTime();
        assertEquals(expResult, result, "Sale time is not the same.");
    }

    @Test
    public void testFetchTotalPrice() {
        float expResult = 1000;
        float result = instance.fetchTotalPrice();
        assertEquals(expResult, result, "Total price is not the same.");
    }

    @Test
    public void testFetchTotalVAT() {
        float expResult = 100;
        float result = instance.fetchTotalVAT();
        assertEquals(expResult, result, "Total VAT is not the same.");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
