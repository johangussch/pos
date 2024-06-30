package se.kth.iv1350.pos.integration;

/**
 * Represents a connection to the database.
 */
public class DatabaseConnection {

    /**
     * Creates a new instance of a database connection.
     */
    public DatabaseConnection() throws DatabaseConnectionException{
    }

    /**
     * Connects to the inventory system.
     * @returns an instance of the inventory system.
     */
    public InventorySystem connectToInventorySystem() {
        return new InventorySystem();
    }

    /** 
     * Connects to the accounting system. 
     * @returns an instance of the accounting system.
     */
    public AccountingSystem connectToAccountingSystem() {
        return new AccountingSystem();
    }

    /**
     * Simulates a database connection error.
     * @throws DatabaseConnectionException
     */
    public void simulateDatabaseConnectionError() throws DatabaseConnectionException {
        throw new DatabaseConnectionException("Could not connect to the database.");
    }
}
