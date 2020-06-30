package main.java.com.oop;

import main.java.com.oop.exceptions.InvalidIngredientTypeException;

public class Ingredient {
    private final String ingredientName;
    private final IngredientType ingredientType;
    private final Double timeForBaking;

    public Ingredient(String ingredientName, IngredientType ingredientType) throws InvalidIngredientTypeException {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;

        switch (ingredientType) {
            case Dough -> this.timeForBaking = 2.0;
            case Sauce, Cheese -> this.timeForBaking = 1.0;
            case Vegetable -> this.timeForBaking = 0.5;
            case Meat -> this.timeForBaking = 1.5;
            default -> throw new InvalidIngredientTypeException();
        }
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public Double getTimeForBaking() {
        return timeForBaking;
    }

    @Override
    public String toString() {
        return ingredientType + "{ " + ingredientName + " }";
    }
}
