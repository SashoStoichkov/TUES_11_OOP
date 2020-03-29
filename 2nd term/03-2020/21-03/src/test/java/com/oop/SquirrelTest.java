package test.java.com.oop;

import main.java.com.oop.Cake;
import main.java.com.oop.NoMoreFoodException;
import main.java.com.oop.Nuts;
import main.java.com.oop.Squirrel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelTest {
    private Squirrel squirrel;

    @BeforeEach
    void setUp() throws NoMoreFoodException {
        squirrel = new Squirrel("Pesho", "red", 12);
        squirrel.addFood(new Nuts(10d, 10d));
    }

    @Test
    void getName() {
        assertEquals(squirrel.getName(), "Pesho");
    }

    @Test
    void getType() {
        assertEquals(squirrel.getType(), "red");
    }

    @Test
    void getAge() {
        assertEquals(squirrel.getAge(), 12);
    }

    @Test
    void setAge() {
        assertEquals(squirrel.getAge(), 12);

        squirrel.setAge(squirrel.getAge() + 1);

        assertEquals(squirrel.getAge(), 13);
    }

    @Test
    void testToString() {
        assertEquals(squirrel.toString(), "<red> Pesho(12)");
    }

    @Test
    void getFoodFound() throws NoMoreFoodException {
        assertEquals(squirrel.getFoodFound(), 1);

        squirrel.addFood(new Nuts(10d, 10d));

        assertEquals(squirrel.getFoodFound(), 2);
    }

    @Test
    void getMaxFoodPerYear() {
        assertEquals(squirrel.getMaxFoodPerYear(), 4);
    }

    @Test
    void addFood() throws NoMoreFoodException {
        squirrel.addFood(new Nuts(10d, 10d));
        squirrel.addFood(new Nuts(10d, 10d));

        assertThrows(NoMoreFoodException.class, () -> squirrel.addFood(new Nuts(10d, 10d)), "No more food for you!");
        assertEquals(squirrel.getFoodFound(), 4);
    }

    @Test
    void passWinter() {
        assertEquals(squirrel.getFoodFound(), 1);

        squirrel.passWinter();

        assertEquals(squirrel.getFoodFound(), 0);
        assertEquals(squirrel.toString(), "<red> Pesho(13)");
        assertEquals(squirrel.getTotalFoodScore(), 100.0);
    }

    @Test
    void getTotalFoodScore() {
        assertEquals(squirrel.getTotalFoodScore(), 100.0);

        squirrel.passWinter();

        assertEquals(squirrel.getTotalFoodScore(), 100.0);
    }

    @Test
    void getBurrowString() throws NoMoreFoodException {
        assertEquals(squirrel.getBurrowString(), "Burrow{foodList=[Food{name='nuts', quantity=10.0, quality=10.0, age=0, foodScore=100.0}]}");

        squirrel.addFood(new Cake(10d, 10d));

        assertEquals(squirrel.getBurrowString(), "Burrow{foodList=[Food{name='nuts', quantity=10.0, quality=10.0, age=0, foodScore=100.0}, Food{name='cake', quantity=10.0, quality=10.0, age=0, foodScore=100.0}]}");
    }
}