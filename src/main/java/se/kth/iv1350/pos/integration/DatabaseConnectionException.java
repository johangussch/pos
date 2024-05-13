package se.kth.iv1350.pos.integration;

public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String errorMsg){
        super(errorMsg);
    }
}
