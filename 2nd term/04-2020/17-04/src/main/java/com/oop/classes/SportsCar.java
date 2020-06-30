package main.java.com.oop.classes;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.enums.*;

public class SportsCar extends Car {
    public SportsCar(Model model, Integer year, Integer price, EngineType engineType, Region region) {
        super(model, year, price, engineType, region);
    }
}
