package main.java.com.oop;

public class City {
    private final Integer ID;
    private final String name;
    private static Integer numberCities = 0;

    public City(String name) {
        this.ID = numberCities;
        this.name = name;
        numberCities++;
    }

    public String getName() {
        return name;
    }
}
