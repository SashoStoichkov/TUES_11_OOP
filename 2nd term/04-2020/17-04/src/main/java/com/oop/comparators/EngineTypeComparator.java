package main.java.com.oop.comparators;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.abstracts.Comparator;

public class EngineTypeComparator extends Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getEngineType().toString().compareTo(o2.getEngineType().toString());
    }
}
