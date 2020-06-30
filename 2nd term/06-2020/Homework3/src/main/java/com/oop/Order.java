package main.java.com.oop;

import main.java.com.oop.exceptions.RequirementsNotMetException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Integer id;
    private final List<Ingredient> ingredients;
    private Map<IngredientType, Integer> requirementsMap;

    public Order(Integer id, List<Ingredient> ingredients) throws RequirementsNotMetException {
        this.id = id;
        this.requirementsMap = generateMap();

        if (minimumRequirements(ingredients)) this.ingredients = ingredients;
        else throw new RequirementsNotMetException();
    }

    protected Boolean minimumRequirements(List<Ingredient> ingredients) {
        ingredients.forEach(ingredient -> {
            Integer newAmount = requirementsMap.get(ingredient.getIngredientType()) + 1;
            requirementsMap.put(ingredient.getIngredientType(), newAmount);
        });

        return requirementsMet();
    }

    private Map<IngredientType, Integer> generateMap() {
        Map<IngredientType, Integer> map = new HashMap<>();

        map.put(IngredientType.Dough, 0);
        map.put(IngredientType.Sauce, 0);
        map.put(IngredientType.Vegetable, 0);
        map.put(IngredientType.Cheese, 0);
        map.put(IngredientType.Meat, 0);

        return map;
    }

    protected Boolean requirementsMet() {
        return ((requirementsMap.get(IngredientType.Dough).equals(1)) &&
                (requirementsMap.get(IngredientType.Sauce).equals(1) || requirementsMap.get(IngredientType.Sauce).equals(2)) &&
                (requirementsMap.get(IngredientType.Cheese) >= 1));
    }

    @Override
    public String toString() {
        return "Order{ " + id + " }";
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
