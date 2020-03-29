package test.java.com.oop;

import main.java.com.oop.Cake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CakeTest {
    private Cake cake;

    @BeforeEach
    void setUp() {
        cake = new Cake(20d, 10d);
    }

    @Test
    void getName() {
        assertEquals(cake.getName(), "cake");
    }

    @Test
    void getQuantity() {
        assertEquals(cake.getQuantity(), 20.0);
    }

    @Test
    void getQuality() {
        assertEquals(cake.getQuality(), 10.0);
    }

    @Test
    void getFoodScore() {
        assertEquals(cake.getFoodScore(), 200.0);
    }

    @Test
    void getAge() {
        assertEquals(cake.getAge(), 0);
    }

    @Test
    void testToString() {
        assertEquals(cake.toString(), "Food{name='cake', quantity=20.0, quality=10.0, age=0, foodScore=200.0}");
    }

    @Test
    void passOneWinter() {
        cake.passWinter();
        assertEquals(cake.getFoodScore(), 137.26, 0.01);
        assertEquals(cake.getAge(), 1);
    }

    @Test
    void passTwoWinters() {
        cake.passWinter();
        cake.passWinter();
        assertEquals(cake.getFoodScore(), 47.03, 0.01);
        assertEquals(cake.getAge(), 2);
    }

    @Test
    void setName() {
        assertEquals(cake.getName(), "cake");
        cake.setName("Pesho");
        assertEquals(cake.getName(), "Pesho");
    }

    @Test
    void setQuantity() {
        assertEquals(cake.getQuantity(), 20.0);
        cake.setQuantity(45.62);
        assertEquals(cake.getQuantity(), 45.62);
    }

    @Test
    void setQuality() {
        assertEquals(cake.getQuality(), 10.0);
        cake.setQuality(45.62);
        assertEquals(cake.getQuality(), 45.62);
    }

    @Test
    void setAge() {
        assertEquals(cake.getAge(), 0);
        cake.setAge(45);
        assertEquals(cake.getAge(), 45);
    }
}