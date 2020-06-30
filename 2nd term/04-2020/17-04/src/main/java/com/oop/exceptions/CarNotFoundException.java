package main.java.com.oop.exceptions;

public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
        super("Car not found!");
    }
}
