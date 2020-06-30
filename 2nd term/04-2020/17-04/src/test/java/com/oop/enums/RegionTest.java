package test.java.com.oop.enums;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.classes.SportsCar;
import main.java.com.oop.enums.EngineType;
import main.java.com.oop.enums.Model;
import main.java.com.oop.enums.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {
    Region region;
    Car car;

    @BeforeEach
    void setUp() {
        region = Region.RUSE;
        car = new SportsCar(Model.FERRARI, 2020, 10000, EngineType.HYBRID, region);
    }

    @Test
    void getPrefix() {
        assertEquals("P", car.getRegion().getPrefix());
    }

    @Test
    void incrementAndGetCounter() {
        assertEquals(0, Region.getCounter(region));
        Car car1 = new SportsCar(Model.FERRARI, 2020, 9500, EngineType.DIESEL, region);
        assertEquals(1, Region.getCounter(region));
    }
}
