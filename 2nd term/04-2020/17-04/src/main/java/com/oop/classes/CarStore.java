package main.java.com.oop.classes;

import main.java.com.oop.abstracts.*;
import main.java.com.oop.comparators.YearComparator;
import main.java.com.oop.enums.Model;
import main.java.com.oop.exceptions.CarNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarStore {
    private List<Car> carList;

    public CarStore() {
        this.carList = new ArrayList<>();
    }

    public boolean add(Car car) {
        return carList.add(car);
    }

    public boolean addAll(List<Car> cars) {
        return carList.addAll(cars);
    }

    public boolean remove(Car car) {
        return carList.remove(car);
    }

    public Car getCarByRegistrationNumber(String registrationNumber) throws CarNotFoundException {
        for (Car car : carList) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return car;
            }
        }

        throw new CarNotFoundException();
    }

    public List<Car> getCarsByModel(Model model) {
        List<Car> carsByModel = new ArrayList<>();

        for (Car car : carList) {
            if (car.getModel().equals(model)) {
                carsByModel.add(car);
            }
        }

        carsByModel.sort(new YearComparator());
        return carsByModel;
    }

    public List<Car> getCars() {
        Collections.sort(carList);
        return carList;
    }

    public List<Car> getCars(Comparator<Car> comparator) {
        carList.sort(comparator);
        return carList;
    }

    public List<Car> getCars(Comparator<Car> comparator, boolean isReversed) {
        carList.sort(comparator);
        if (isReversed) {
            Collections.reverse(carList);
        }

        return carList;
    }

    public Integer getNumberOfCars() {
        return carList.size();
    }

    public Integer getTotalPriceOfCars() {
        Integer price = 0;

        for (Car car : carList) {
            price += car.getPrice();
        }

        return price;
    }
}
