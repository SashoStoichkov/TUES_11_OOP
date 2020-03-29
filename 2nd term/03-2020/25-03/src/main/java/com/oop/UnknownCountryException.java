package main.java.com.oop;

public class UnknownCountryException extends Exception {
    public UnknownCountryException() {
        super("Unknown country");
    }

    public UnknownCountryException(String message) {
        super(message);
    }
}
