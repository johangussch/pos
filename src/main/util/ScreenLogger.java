package se.kth.iv1350.polymlogger;

/**
 * Prints log messages to the screen.
 */
public class ScreenLogger implements Logger {

    /**
     * The specified string is logged to a log file.
     *
     * @param message The string that will be printed to the log file.
     */
    @Override
    public void log(String message) {
        System.out.println(message);
    }

}
