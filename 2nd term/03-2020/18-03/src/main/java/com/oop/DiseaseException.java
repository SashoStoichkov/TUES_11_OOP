package main.java.com.oop;

public class DiseaseException extends Exception {
    public DiseaseException() {
        super("This disease is unknown!\nThe valid ones are: COVID_19, COLD, FATIGUE");
    }

    public DiseaseException(String message) {
        super(message);
    }
}
