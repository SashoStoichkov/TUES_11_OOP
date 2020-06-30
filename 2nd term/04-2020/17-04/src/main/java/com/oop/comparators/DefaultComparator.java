package main.java.com.oop.comparators;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.abstracts.Comparator;

public class DefaultComparator extends Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        int modelCompare = o1.getModel().toString().compareTo(o2.getModel().toString());

        if (modelCompare != 0) {
            return modelCompare;
        }

        return Integer.compare(o1.getYear(), o2.getYear());
    }
}
