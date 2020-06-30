package main.java.com.oop.exceptions;

public class RequirementsNotMetException extends Exception {
    public RequirementsNotMetException() {
        super("Requirements for Pizza are not met!");
    }
}
