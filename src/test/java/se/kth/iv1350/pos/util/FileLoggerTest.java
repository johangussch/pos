package se.kth.iv1350.pos.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FileLoggerTest {
    private FileLogger fileLogger;
    private String logFilePath = "log.txt";

    @BeforeEach
    public void setUp() {
        fileLogger = new FileLogger();
    }

    @Test
    public void testLogMessage() {
        String message = "Leif är bäst!";
        fileLogger.log(message);

        assertTrue(fileExists(logFilePath));
        assertTrue(fileContains(logFilePath, message));
    }

    @AfterEach
    public void tearDown() {
        deleteFile(logFilePath);
    }

    private boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    private boolean fileContains(String filePath, String content) {
        try {
            String fileContent = Files.readString(Paths.get(filePath));
            return fileContent.contains(content);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}