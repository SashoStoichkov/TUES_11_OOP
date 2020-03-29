package main.java.com.oop;

public class NotFullInfoException extends Exception {
    public NotFullInfoException() {
        super("Something is missing!");
    }

    public NotFullInfoException(String message) {
        super(message + " is missing!");
    }
}
