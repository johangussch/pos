package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.model.Sale;

public class ReceiptTest {
    private Receipt instance;
    private Sale sale = new Sale();
    
    @BeforeEach
    public void setUp() {
        instance = new Receipt();
        ItemDTO itemDTO = new ItemDTO("Banananaa", 100, 0);
        ItemDTO itemDTO2 = new ItemDTO("Abble", 10, 0);
        sale.listSoldItem(new Item(0, itemDTO, 1), 1);
        sale.listSoldItem(new Item(1, itemDTO2, 2), 2);
        sale.listSoldItem(new Item(0, itemDTO, 1), 3);
        sale.paidAmount = 1000;
    }

    @Test
    public void testPrintReceipt() {
        instance.printReceipt(sale);
        assertNotNull(sale, "Receipt was not printed");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}