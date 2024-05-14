package se.kth.iv1350.pos.util;

/**
 * Prints log messages. The destination of the log is decided by the class implementing the
 * interface.
 */
public interface Logger {
    /**
     * Logs the specified string.
     *
     * @param message The string that will be logged.
     */
    public void log(String message);
}
