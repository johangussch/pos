package se.kth.iv1350.pos.integration;

/**
 * Thrown when an item ID is not found in the inventory.
 */
public class NoItemIDFoundException extends Exception {
    public NoItemIDFoundException(String errorMsg){
        super(errorMsg);

        System.out.println(errorMsg);
    }
}