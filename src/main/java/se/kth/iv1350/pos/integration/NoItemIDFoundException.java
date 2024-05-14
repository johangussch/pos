package se.kth.iv1350.pos.integration;

/**
 * Thrown when an item ID is not found in the inventory.
 */
public class NoItemIDFoundException extends Exception {
    /**
     * Creates a new instance of the exception with a message specifying what went wrong.
     * 
     * @param errorMsg The message that explains what went wrong.
     */
    public NoItemIDFoundException(String errorMsg){
        super(errorMsg);

        System.out.println(errorMsg);
    }
}