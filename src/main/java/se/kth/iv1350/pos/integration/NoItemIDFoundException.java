package se.kth.iv1350.pos.integration;

public class NoItemIDFoundException extends Exception {
    public NoItemIDFoundException(String errorMsg){
        super(errorMsg);
    }
}
