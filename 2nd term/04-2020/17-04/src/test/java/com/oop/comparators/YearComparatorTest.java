package test.java.com.oop.comparators;

import main.java.com.oop.abstracts.Car;
import main.java.com.oop.classes.OrdinaryCar;
import main.java.com.oop.classes.SportsCar;
import main.java.com.oop.comparators.YearComparator;
import main.java.com.oop.enums.EngineType;
import main.java.com.oop.enums.Model;
import main.java.com.oop.enums.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearComparatorTest {
    private YearComparator yearComparator;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        yearComparator = new YearComparator();

        car1 = new SportsCar(Model.MERCEDES, 2020, 8000, EngineType.HYBRID, Region.SOFIA);
        car2 = new SportsCar(Model.MERCEDES, 2019, 10000, EngineType.DIESEL, Region.BURGAS);
        car3 = new OrdinaryCar(Model.ALPHA_ROMEO, 2017, 5000, EngineType.GASOLINE, Region.GABROVO);
    }

    @Test
    void compareEquals() {
        int result = yearComparator.compare(car1, car1);
        assertEquals(0, result);
        assertFalse(result > 0);
        assertFalse(result < 0);

        result = yearComparator.compare(car2, car2);
        assertEquals(0, result);
        assertFalse(result > 0);
        assertFalse(result < 0);

        result = yearComparator.compare(car3, car3);
        assertEquals(0, result);
        assertFalse(result > 0);
        assertFalse(result < 0);
    }

    @Test
    void compareGreaterThan() {
        int result = yearComparator.compare(car1, car2);
        assertTrue(result > 0);
        assertNotEquals(0, result);
        assertFalse(result < 0);

        result = yearComparator.compare(car2, car3);
        assertTrue(result > 0);
        assertNotEquals(0, result);
        assertFalse(result < 0);

        result = yearComparator.compare(car1, car3);
        assertTrue(result > 0);
        assertNotEquals(0, result);
        assertFalse(result < 0);
    }

    @Test
    void compareSmallerThan() {
        int result = yearComparator.compare(car2, car1);
        assertTrue(result < 0);
        assertNotEquals(0, result);
        assertFalse(result > 0);

        result = yearComparator.compare(car3, car2);
        assertTrue(result < 0);
        assertNotEquals(0, result);
        assertFalse(result > 0);

        result = yearComparator.compare(car3, car1);
        assertTrue(result < 0);
        assertNotEquals(0, result);
        assertFalse(result > 0);
    }
}
