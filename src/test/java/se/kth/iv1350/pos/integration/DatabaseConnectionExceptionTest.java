package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionExceptionTest {
    private DatabaseConnection databaseConnection;
    
    @BeforeEach
    public void setUp() throws DatabaseConnectionException {
        databaseConnection = new DatabaseConnection();
    }

    @Test
    public void testConnectionToNonExistingDatabase(){
        assertThrows(DatabaseConnectionException.class, () -> {
            databaseConnection.simulateDatabaseConnectionError();
        });
    }

    @AfterEach
    public void tearDown() {
        databaseConnection = null;
    }
}