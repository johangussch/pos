package se.kth.iv1350.pos.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutputLogger implements Logger{
    private PrintWriter logStream;

    public TotalRevenueFileOutputLogger() {
        try {
            File logFile = new File("RevenueLogs.txt");
            if (logFile.exists()) {
                logStream = new PrintWriter(new FileWriter(logFile, true), true);
            } else {
                logStream = new PrintWriter(new FileWriter(logFile), true);
            }
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        logStream.println(message);
    }
}
