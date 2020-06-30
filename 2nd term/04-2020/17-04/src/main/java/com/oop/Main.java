package main.java.com.oop;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.classes.*;
import main.java.com.oop.comparators.*;
import main.java.com.oop.enums.*;

public class Main {

    public static void main(String[] args) {
        Car car = new SportsCar(Model.MERCEDES, 2020, 8000, EngineType.HYBRID, Region.SOFIA);
        Car car2 = new SportsCar(Model.MERCEDES, 2019, 10000, EngineType.DIESEL, Region.BURGAS);
        Car car3 = new OrdinaryCar(Model.ALPHA_ROMEO, 2017, 5000, EngineType.GASOLINE, Region.GABROVO);

        CarStore carStore = new CarStore();
        carStore.add(car);
        carStore.add(car2);
        carStore.add(car3);

        System.out.println(carStore.getCars());
//        System.out.println(carStore.getCars(new PriceComparator()));
//        System.out.println(carStore.getCars(new EngineTypeComparator()));
//        System.out.println(carStore.getCars(new RegionComparator()));

        System.out.println(carStore.getCarsByModel(Model.MERCEDES));
    }
}
