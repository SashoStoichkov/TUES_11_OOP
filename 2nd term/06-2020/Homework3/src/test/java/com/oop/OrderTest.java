package test.java.com.oop;

import main.java.com.oop.Ingredient;
import main.java.com.oop.IngredientType;
import main.java.com.oop.Order;
import main.java.com.oop.exceptions.InvalidIngredientTypeException;
import main.java.com.oop.exceptions.RequirementsNotMetException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void minimumRequirementsMet() throws RequirementsNotMetException, InvalidIngredientTypeException {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient("White Dough", IngredientType.Dough));
        ingredients.add(new Ingredient("Mozzarella", IngredientType.Cheese));
        ingredients.add(new Ingredient("Tomato Sauce", IngredientType.Sauce));

        Order order = new Order(1, ingredients);
        assertNotNull(order);
    }

    // така съм си написал кода, че не знам как да тествам варианта, в който не може да се направи пица
}
