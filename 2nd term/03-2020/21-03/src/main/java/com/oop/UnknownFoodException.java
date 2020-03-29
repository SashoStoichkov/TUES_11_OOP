package main.java.com.oop;

public class UnknownFoodException extends Exception {
    public UnknownFoodException() {
        super("Unknown food detected!");
    }

    public UnknownFoodException(String message) {
        super(message);
    }
}
