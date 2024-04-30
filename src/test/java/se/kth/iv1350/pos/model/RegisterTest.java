package se.kth.iv1350.pos.model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RegisterTest {
    private Register instance;

    @BeforeEach
    public void setUp() {
        instance = new Register();
    }

    @Test
    public void testIncreaseAmountInRegisterHandlingTheSale() {
        double amount = 100;
        instance.increaseAmount(amount);
        assertEquals(100, instance.amount, "Amount was not increased");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }
}
