package se.kth.iv1350.pos.util;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.util.*;

public class LoggerTest {
    private PrintWriter logstream = new FileLogger();
    String msg = "test message";
    
    @BeforeEach
    public void setUp() {
        logStream = new PrintWriter(new FileWriter("log.txt"), true);
    }

    @Test
    public void testThatLoggerLogs(){
        logStream.log(msg);
    }

    @AfterEach
    public void tearDown() {
       
    }
}
