package main.java.com.oop;

public class Patient {
    private final String firstName;
    private final String lastName;
    private final String EGN;

    public Patient(String firstName, String lastName, String EGN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.EGN = EGN;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEGN() {
        return EGN;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + this.getFullName() + '\'' +
                ", EGN='" + this.getEGN() + '\'' +
                '}';
    }
}
