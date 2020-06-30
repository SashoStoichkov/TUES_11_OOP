package main.java.com.oop.comparators;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.abstracts.Comparator;

public class RegionComparator extends Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getRegion().toString().compareTo(o2.getRegion().toString());
    }
}
