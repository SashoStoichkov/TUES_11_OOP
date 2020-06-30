package main.java.com.oop.abstracts;

public abstract class Comparator <T extends Car> implements java.util.Comparator<Car> {
    public abstract int compare(T o1, T o2);
}
