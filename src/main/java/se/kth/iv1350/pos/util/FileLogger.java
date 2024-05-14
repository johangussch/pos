package se.kth.iv1350.pos.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logs exceptions and events to a file.
 */
public class FileLogger implements Logger {
    private PrintWriter logStream;

    public FileLogger() {
        try {
            File oldLog = new File("log.txt");
            if (oldLog.exists()) {
                File renamedOldLog = new File("old_log.txt");
                if (renamedOldLog.exists()) {
                    renamedOldLog.delete(); 
                }
                oldLog.renameTo(renamedOldLog); 
            }
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
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
