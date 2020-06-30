package main.java.com.oop.abstracts;

import main.java.com.oop.enums.*;
import main.java.com.oop.interfaces.Comparable;

import java.util.Random;

public abstract class Car implements Comparable<Car> {
    private final Model model;
    private final Integer year;
    private final Integer price;
    private final EngineType engineType;
    private final Region region;
    private final String registrationNumber;

    public Car(Model model, Integer year, Integer price, EngineType engineType, Region region) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.region = region;
        Region.incrementCounter(region);
        this.registrationNumber = setRegistrationNumber();
    }

    public Model getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPrice() {
        return price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Region getRegion() {
        return region;
    }

    public String setRegistrationNumber() {
        String regNumber = "";
        Random random = new Random();

        regNumber += region.getPrefix();
        regNumber += Integer.toString(1000 + Region.getCounter(region));
        regNumber += (char) (random.nextInt(26) + 'A');
        regNumber += (char) (random.nextInt(26) + 'A');

        return regNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public int compareTo(Car o) {
        int modelCompare = this.getModel().toString().compareTo(o.getModel().toString());

        if (modelCompare != 0) {
            return modelCompare;
        } else {
            return Integer.compare(this.getYear(), o.getYear());
        }
    }

    @Override
    public String toString() {
        return "\n{" +
                year + " " + model + " " + engineType + " " +
                price + "лв. " + region + " '" + registrationNumber +
                "'}";
    }
}
