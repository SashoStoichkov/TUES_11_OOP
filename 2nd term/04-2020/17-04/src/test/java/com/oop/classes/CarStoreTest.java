package test.java.com.oop.classes;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.classes.CarStore;
import main.java.com.oop.classes.OrdinaryCar;
import main.java.com.oop.classes.SportsCar;
import main.java.com.oop.comparators.EngineTypeComparator;
import main.java.com.oop.comparators.RegionComparator;
import main.java.com.oop.enums.EngineType;
import main.java.com.oop.enums.Model;
import main.java.com.oop.enums.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarStoreTest {
    private CarStore carStore;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        carStore = new CarStore();
        car1 = new SportsCar(Model.MERCEDES, 2020, 8000, EngineType.HYBRID, Region.SOFIA);
        car2 = new SportsCar(Model.MERCEDES, 2019, 10000, EngineType.DIESEL, Region.BURGAS);
        car3 = new OrdinaryCar(Model.ALPHA_ROMEO, 2017, 5000, EngineType.GASOLINE, Region.GABROVO);
    }

    @Test
    void add() {
        assertTrue(carStore.add(car1));
        assertEquals(carStore.getCars().get(0), car1);
    }

    @Test
    void addAll() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        assertTrue(carStore.addAll(carList));
        assertEquals(carStore.getCars().get(2), car1);
        assertEquals(carStore.getCars().get(1), car2);
        assertEquals(carStore.getCars().get(0), car3);
    }

    @Test
    void remove() {
        carStore.add(car1);
        assertEquals(carStore.getCars().get(0), car1);
        assertTrue(carStore.remove(car1));
        assertEquals(0, carStore.getCars().size());
    }

    @Test
    void getCarByRegistrationNumber() {
        carStore.add(car1);
        Car car = carStore.getCars().get(0);
        assertEquals(car.getRegistrationNumber(), car1.getRegistrationNumber());
    }

    @Test
    void getCarsByModel() {
        carStore.add(car1);
        carStore.add(car2);

        List<Car> carList = carStore.getCarsByModel(Model.MERCEDES);
        assertEquals(carList.get(0), car2);
        assertEquals(carList.get(1), car1);
    }

    @Test
    void getCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carStore.addAll(carList);

        List<Car> resultCarList = carStore.getCars();

        assertEquals(resultCarList.get(2), car1);
        assertEquals(resultCarList.get(1), car2);
        assertEquals(resultCarList.get(0), car3);
    }

    @Test
    void getCarsWithComparator() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carStore.addAll(carList);

        List<Car> resultCarList = carStore.getCars(new RegionComparator());

        assertEquals(resultCarList.get(2), car1);
        assertEquals(resultCarList.get(0), car2);
        assertEquals(resultCarList.get(1), car3);
    }

    @Test
    void getCarsWithComparatorAndReversed() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carStore.addAll(carList);

        List<Car> resultCarList = carStore.getCars(new EngineTypeComparator(), true);

        assertEquals(resultCarList.get(0), car1);
        assertEquals(resultCarList.get(2), car2);
        assertEquals(resultCarList.get(1), car3);
    }

    @Test
    void getNumberOfCars() {
        assertEquals(carStore.getNumberOfCars(), 0);
        carStore.add(car1);
        assertEquals(carStore.getNumberOfCars(), 1);
        carStore.add(car2);
        assertEquals(carStore.getNumberOfCars(), 2);
        carStore.add(car3);
        assertEquals(carStore.getNumberOfCars(), 3);
    }

    @Test
    void getTotalPriceOfCars() {
        assertEquals(carStore.getTotalPriceOfCars(), 0);
        carStore.add(car1);
        assertEquals(carStore.getTotalPriceOfCars(), 8000);
        carStore.add(car2);
        assertEquals(carStore.getTotalPriceOfCars(), 18000);
        carStore.add(car3);
        assertEquals(carStore.getTotalPriceOfCars(), 23000);
    }
}
