package test.java.com.oop;

import main.java.com.oop.McBurger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class McBurgerTest {
    private McBurger mcBurger;

    @BeforeEach
    void setUp() {
        mcBurger = new McBurger(20d, 10d);
    }

    @Test
    void getName() {
        assertEquals(mcBurger.getName(), "mcburger");
    }

    @Test
    void getQuantity() {
        assertEquals(mcBurger.getQuantity(), 20.0);
    }

    @Test
    void getQuality() {
        assertEquals(mcBurger.getQuality(), 10.0);
    }

    @Test
    void getFoodScore() {
        assertEquals(mcBurger.getFoodScore(), 200.0);
    }

    @Test
    void getAge() {
        assertEquals(mcBurger.getAge(), 0);
    }

    @Test
    void testToString() {
        assertEquals(mcBurger.toString(), "Food{name='mcburger', quantity=20.0, quality=10.0, age=0, foodScore=200.0}");
    }

    @Test
    void passOneWinter() {
        mcBurger.passWinter();
        assertEquals(mcBurger.getFoodScore(), 80.0);
        assertEquals(mcBurger.getAge(), 1);
    }

    @Test
    void passTwoWinters() {
        mcBurger.passWinter();
        mcBurger.passWinter();
        assertEquals(mcBurger.getFoodScore(), 80.0);
        assertEquals(mcBurger.getAge(), 2);
    }

    @Test
    void setName() {
        assertEquals(mcBurger.getName(), "mcburger");
        mcBurger.setName("Pesho");
        assertEquals(mcBurger.getName(), "Pesho");
    }

    @Test
    void setQuantity() {
        assertEquals(mcBurger.getQuantity(), 20.0);
        mcBurger.setQuantity(45.62);
        assertEquals(mcBurger.getQuantity(), 45.62);
    }

    @Test
    void setQuality() {
        assertEquals(mcBurger.getQuality(), 10.0);
        mcBurger.setQuality(45.62);
        assertEquals(mcBurger.getQuality(), 45.62);
    }

    @Test
    void setAge() {
        assertEquals(mcBurger.getAge(), 0);
        mcBurger.setAge(45);
        assertEquals(mcBurger.getAge(), 45);
    }
}