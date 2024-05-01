package se.kth.iv1350.pos.model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ItemDTOTest {
    private ItemDTO instance;

    @BeforeEach
    public void setUp() {
        instance = new ItemDTO("Mommas testbanana", "Used condition", 1000, 100);
    }

    @Test
    public void testFetchItemName() {
        String expResult = "Mommas testbanana";
        String result = instance.fetchItemName();
        assertEquals(expResult, result, "Item name was not fetched");
    }

    @Test
    public void testFetchItemDescription() {
        String expResult = "Used condition";
        String result = instance.fetchItemDescription();
        assertEquals(expResult, result, "Item description was not fetched");
    }

    @Test
    public void testFetchItemPrice() {
        double expResult = 1000;
        double result = instance.fetchItemPrice();
        assertEquals(expResult, result, "Item price was not fetched");
    }

    @Test
    public void testFetchItemVAT() {
        double expResult = 100;
        double result = instance.fetchItemVAT();
        assertEquals(expResult, result, "Item VAT was not fetched");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
