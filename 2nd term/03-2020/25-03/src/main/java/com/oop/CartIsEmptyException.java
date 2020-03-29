package main.java.com.oop;

public class CartIsEmptyException extends Exception {
    public CartIsEmptyException() {
        super("Cart is EMPTY!");
    }

    public CartIsEmptyException(String message) {
        super(message);
    }
}
