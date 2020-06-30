package test.java.com.oop.abstracts;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.enums.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(Model.FERRARI, 2020, 10000, EngineType.HYBRID, Region.GABROVO) {};
    }

    @Test
    void getModel() {
        assertEquals(Model.FERRARI, car.getModel());
    }

    @Test
    void getYear() {
        assertEquals(2020, car.getYear());
    }

    @Test
    void getPrice() {
        assertEquals(10000, car.getPrice());
    }

    @Test
    void getEngineType() {
        assertEquals(EngineType.HYBRID, car.getEngineType());
    }

    @Test
    void getRegion() {
        assertEquals(Region.GABROVO, car.getRegion());
    }

    @Test
    void getRegistrationNumber() {
        String registrationNumber = car.getRegistrationNumber();

        String regionPrefix = registrationNumber.substring(0, 2);
        assertEquals("EB", regionPrefix);
    }
}
