package se.kth.iv1350.pos.integration;

/**
 * Thrown when the database connection fails.
 */
public class DatabaseConnectionException extends Exception {
    /**
     * Creates a new instance of the exception with a message specifying what went wrong.
     * 
     * @param errorMsg The message that explains what went wrong.
     */
    public DatabaseConnectionException(String errorMsg){
        super(errorMsg);
    }
}