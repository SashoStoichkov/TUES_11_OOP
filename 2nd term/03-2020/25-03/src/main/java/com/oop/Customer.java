package main.java.com.oop;

public class Customer {
    private final Integer ID;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private static Integer numberCustomers = 0;

    public Customer(String firstName, String lastName, Address address) throws NotFullInfoException {
        this.ID = numberCustomers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        validate();
        numberCustomers++;
    }

    public Integer getID() {
        return ID;
    }

    void validate() throws NotFullInfoException {
        if (firstName == null || firstName.trim().equals("")) {
            throw new NotFullInfoException("First name");
        }

        if (lastName == null || lastName.trim().equals("")) {
            throw new NotFullInfoException("Last name");
        }
    }

    public Address getAddress() {
        return address;
    }
}
