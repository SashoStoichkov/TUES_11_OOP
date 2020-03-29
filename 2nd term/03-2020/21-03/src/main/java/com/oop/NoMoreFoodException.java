package main.java.com.oop;

public class NoMoreFoodException extends Exception {
    public NoMoreFoodException() {
        super("No more food for you!");
    }

    public NoMoreFoodException(String message) {
        super(message);
    }
}
