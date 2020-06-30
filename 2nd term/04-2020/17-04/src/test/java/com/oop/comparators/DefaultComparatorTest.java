package test.java.com.oop.comparators;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.classes.*;
import main.java.com.oop.comparators.DefaultComparator;
import main.java.com.oop.enums.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultComparatorTest {
    private DefaultComparator defaultComparator;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        defaultComparator = new DefaultComparator();

        car1 = new SportsCar(Model.MERCEDES, 2020, 8000, EngineType.HYBRID, Region.SOFIA);
        car2 = new SportsCar(Model.MERCEDES, 2019, 10000, EngineType.DIESEL, Region.BURGAS);
        car3 = new OrdinaryCar(Model.ALPHA_ROMEO, 2017, 5000, EngineType.GASOLINE, Region.GABROVO);
    }

    @Test
    void compareEquals() {
        int result = defaultComparator.compare(car1, car1);
        assertEquals(0, result);
        assertFalse(result > 0);
        assertFalse(result < 0);

        result = defaultComparator.compare(car2, car2);
        assertEquals(0, result);
        assertFalse(result > 0);
        assertFalse(result < 0);

        result = defaultComparator.compare(car3, car3);
        assertEquals(0, result);
        assertFalse(result > 0);
        assertFalse(result < 0);
    }

    @Test
    void compareGreaterThan() {
        int result = defaultComparator.compare(car1, car2);
        assertTrue(result > 0);
        assertNotEquals(0, result);
        assertFalse(result < 0);

        result = defaultComparator.compare(car2, car3);
        assertTrue(result > 0);
        assertNotEquals(0, result);
        assertFalse(result < 0);

        result = defaultComparator.compare(car1, car3);
        assertTrue(result > 0);
        assertNotEquals(0, result);
        assertFalse(result < 0);
    }

    @Test
    void compareSmallerThan() {
        int result = defaultComparator.compare(car2, car1);
        assertTrue(result < 0);
        assertNotEquals(0, result);
        assertFalse(result > 0);

        result = defaultComparator.compare(car3, car2);
        assertTrue(result < 0);
        assertNotEquals(0, result);
        assertFalse(result > 0);

        result = defaultComparator.compare(car3, car1);
        assertTrue(result < 0);
        assertNotEquals(0, result);
        assertFalse(result > 0);
    }
}
