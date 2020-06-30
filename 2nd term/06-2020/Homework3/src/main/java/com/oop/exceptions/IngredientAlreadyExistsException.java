package main.java.com.oop.exceptions;

public class IngredientAlreadyExistsException extends Exception {
    public IngredientAlreadyExistsException() {
        super("Error: The ingredient already exists!");
    }
}
