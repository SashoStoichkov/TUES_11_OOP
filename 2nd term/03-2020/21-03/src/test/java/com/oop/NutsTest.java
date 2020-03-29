package test.java.com.oop;

import main.java.com.oop.Nuts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutsTest {
    private Nuts nuts;

    @BeforeEach
    void setUp() {
        nuts = new Nuts(20d, 10d);
    }

    @Test
    void getName() {
        assertEquals(nuts.getName(), "nuts");
    }

    @Test
    void getQuantity() {
        assertEquals(nuts.getQuantity(), 20.0);
    }

    @Test
    void getQuality() {
        assertEquals(nuts.getQuality(), 10.0);
    }

    @Test
    void getFoodScore() {
        assertEquals(nuts.getFoodScore(), 200.0);
    }

    @Test
    void getAge() {
        assertEquals(nuts.getAge(), 0);
    }

    @Test
    void testToString() {
        assertEquals(nuts.toString(), "Food{name='nuts', quantity=20.0, quality=10.0, age=0, foodScore=200.0}");
    }

    @Test
    void passOneWinter() {
        nuts.passWinter();
        assertEquals(nuts.getFoodScore(), 200.0);
        assertEquals(nuts.getAge(), 1);
    }

    @Test
    void passTwoWinters() {
        nuts.passWinter();
        nuts.passWinter();
        assertEquals(nuts.getFoodScore(), 200.0);
        assertEquals(nuts.getAge(), 2);
    }

    @Test
    void setName() {
        assertEquals(nuts.getName(), "nuts");
        nuts.setName("Pesho");
        assertEquals(nuts.getName(), "Pesho");
    }

    @Test
    void setQuantity() {
        assertEquals(nuts.getQuantity(), 20.0);
        nuts.setQuantity(45.62);
        assertEquals(nuts.getQuantity(), 45.62);
    }

    @Test
    void setQuality() {
        assertEquals(nuts.getQuality(), 10.0);
        nuts.setQuality(45.62);
        assertEquals(nuts.getQuality(), 45.62);
    }

    @Test
    void setAge() {
        assertEquals(nuts.getAge(), 0);
        nuts.setAge(45);
        assertEquals(nuts.getAge(), 45);
    }
}