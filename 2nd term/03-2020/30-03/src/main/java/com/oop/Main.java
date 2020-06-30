package main.java.com.oop;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<City> cities = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();

        cities.add(new City("Sofia"));
        cities.add(new City("Burgas"));
        cities.add(new City("Varna"));

        roads.add(new Road("Trakia", 360, 0, 1));
        roads.add(new Road("Hemus", 418, 0, 2));
    }
}
