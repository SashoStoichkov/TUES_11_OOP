package main.java.com.oop.interfaces;

import main.java.com.oop.abstracts.Car;

public interface Comparable <T extends Car> extends java.lang.Comparable<Car> {
    int compareTo(T o);
}
