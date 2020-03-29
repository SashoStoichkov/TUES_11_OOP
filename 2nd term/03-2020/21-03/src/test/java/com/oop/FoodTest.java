package test.java.com.oop;

import main.java.com.oop.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    private Food food;

    @BeforeEach
    void setUp() {
        food = new Food(10d, 10d) {
            @Override
            protected void passWinter() {}
        };
    }

    @Test
    void getName() {
        assertEquals(food.getName(), "unknown food");
    }

    @Test
    void getQuantity() {
        assertEquals(food.getQuantity(), 10.0);
    }

    @Test
    void getQuality() {
        assertEquals(food.getQuality(), 10.0);
    }

    @Test
    void getFoodScore() {
        assertEquals(food.getFoodScore(), 100.0);
    }

    @Test
    void getNewFoodScore() {
        food.setQuantity(20.0);
        food.setQuality(25.0);
        assertEquals(food.getFoodScore(), 500.0);
    }

    @Test
    void getAge() {
        assertEquals(food.getAge(), 0);
    }

    @Test
    void testToString() {
        assertEquals(food.toString(), "Food{name='unknown food', quantity=10.0, quality=10.0, age=0, foodScore=100.0}");
    }

    @Test
    void setName() {
        assertEquals(food.getName(), "unknown food");
        food.setName("Pesho");
        assertEquals(food.getName(), "Pesho");
    }

    @Test
    void setQuantity() {
        assertEquals(food.getQuantity(), 10.0);
        food.setQuantity(45.62);
        assertEquals(food.getQuantity(), 45.62);
    }

    @Test
    void setQuality() {
        assertEquals(food.getQuality(), 10.0);
        food.setQuality(45.62);
        assertEquals(food.getQuality(), 45.62);
    }

    @Test
    void setAge() {
        assertEquals(food.getAge(), 0);
        food.setAge(45);
        assertEquals(food.getAge(), 45);
    }
}