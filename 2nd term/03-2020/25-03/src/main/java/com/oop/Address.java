package main.java.com.oop;

public class Address {
    private final Country country;
    private final String town;
    private final String street;
    private final Integer number;
    private final Integer apartmentNumber;

    public Address(Country country, String town, String street, Integer number, Integer apartmentNumber) throws NotFullInfoException {
        this.country = country;
        this.town = town;
        this.street = street;
        this.number = number;
        this.apartmentNumber = apartmentNumber;
        validate();
    }

    public Country getCountry() {
        return country;
    }

    private void validate() throws NotFullInfoException {
        if (country == null) {
            throw new NotFullInfoException("Country");
        }

        if (town == null || town.trim().equals("")) {
            throw new NotFullInfoException("Town");
        }

        if (street == null || street.trim().equals("")) {
            throw new NotFullInfoException("Street");
        }

        if (number == null || apartmentNumber == null) {
            throw new NotFullInfoException("Number");
        }
    }
}
