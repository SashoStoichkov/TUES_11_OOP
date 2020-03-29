package main.java.com.oop;

public class TooBigAmountException extends Exception {
    public TooBigAmountException() {
        super("That is too much");
    }

    public TooBigAmountException(String message) {
        super(message);
    }
}
