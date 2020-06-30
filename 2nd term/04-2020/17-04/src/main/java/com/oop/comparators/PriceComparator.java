package main.java.com.oop.comparators;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.abstracts.Comparator;

public class PriceComparator extends Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
