package test.java.com.oop;

import main.java.com.oop.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BurrowTest {
    private Burrow burrow;

    @BeforeEach
    void setUp() {
        burrow = new Burrow();
        burrow.addFood(new Nuts(10d, 10d));
    }

    @Test
    void getFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Nuts(10d, 10d));

        assertEquals(burrow.getFoodList().size(), foodList.size());
    }

    @Test
    void addFood() {
        burrow.addFood(new McBurger(20d, 40d));

        assertEquals(burrow.getFoodList().size(), 2);
        assertEquals(burrow.getTotalFoodScore(), 900.0);
        assertEquals(burrow.toString(), "Burrow{foodList=[Food{name='nuts', quantity=10.0, quality=10.0, age=0, foodScore=100.0}, Food{name='mcburger', quantity=20.0, quality=40.0, age=0, foodScore=800.0}]}");
    }

    @Test
    void passWinter() {
        burrow.addFood(new Cake(10d, 10d));

        burrow.passWinter();

        assertEquals(burrow.getTotalFoodScore(), 168.63);
        assertEquals(burrow.toString(), "Burrow{foodList=[Food{name='nuts', quantity=10.0, quality=10.0, age=1, foodScore=100.0}, Food{name='cake', quantity=7.0, quality=9.804, age=1, foodScore=68.63}]}");
    }

    @Test
    void getTotalFoodScore() {
        assertEquals(burrow.getTotalFoodScore(), 100.0);

        burrow.addFood(new McBurger(20d, 40d));

        assertEquals(burrow.getTotalFoodScore(), 900.0);
    }

    @Test
    void testToString() {
        assertEquals(burrow.toString(), "Burrow{foodList=[Food{name='nuts', quantity=10.0, quality=10.0, age=0, foodScore=100.0}]}");

        burrow.addFood(new Cake(10d, 10d));

        assertEquals(burrow.toString(), "Burrow{foodList=[Food{name='nuts', quantity=10.0, quality=10.0, age=0, foodScore=100.0}, Food{name='cake', quantity=10.0, quality=10.0, age=0, foodScore=100.0}]}");
    }
}