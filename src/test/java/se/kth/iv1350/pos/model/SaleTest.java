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
    public void testFetchRunningTotal() {
        double expResult = 0;
        double result = instance.fetchRunningTotal();
        assertEquals(expResult, result, "Running total was not fetched");
    }

    @Test
    public void testFetchSaleInfo() {
        SaleDTO expResult = instance.saleInfo;
        SaleDTO result = instance.fetchSalelnfo();
        assertEquals(expResult, result, "Sale info was not fetched");
    }

    @Test
    public void testListSoldItem() {
        Item item = new Item(1, new ItemDTO("Bananana", 1000, 100), 1);
        instance.listSoldItem(item, 1);
        assertTrue(instance.fetchItems().contains(item), "Item was not added to list");
    }

    @Test
    public void testFetchItems() {
        Item item = new Item(2, new ItemDTO("Bananana", 1000, 100), 1);
        instance.listSoldItem(item, 1);
        assertTrue(instance.fetchItems().contains(item), "Items were not fetched");
    }


    @AfterEach
    public void tearDown() {
        instance = null;
    }

}
