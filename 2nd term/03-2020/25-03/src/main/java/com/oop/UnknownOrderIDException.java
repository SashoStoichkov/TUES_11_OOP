package main.java.com.oop;

public class UnknownOrderIDException extends Exception {
    public UnknownOrderIDException() {
        super("Unknown ID!");
    }

    public UnknownOrderIDException(String message) {
        super(message);
    }
}
