package se.kth.iv1350.pos.integration;

/**
 * Thrown when the database connection fails.
 */
public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String errorMsg){
        super(errorMsg);
    }
}