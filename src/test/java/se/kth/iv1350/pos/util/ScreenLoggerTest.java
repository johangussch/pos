package se.kth.iv1350.pos.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScreenLoggerTest {
    private ScreenLogger screenLogger;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        screenLogger = new ScreenLogger();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testLogMessage() {
        String message = "Leif är bäst!!";
        screenLogger.log(message);

        assertEquals(message + System.lineSeparator(), outputStream.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}