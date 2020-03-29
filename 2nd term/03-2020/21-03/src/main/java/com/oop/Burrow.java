package main.java.com.oop;

import java.util.ArrayList;

public class Burrow {
    private ArrayList<Food> foodList;

    public Burrow() {
        foodList = new ArrayList<>();
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void passWinter() {
        for (Food food : foodList) {
            food.passWinter();
        }
    }

    public Double getTotalFoodScore() {
        Double totalFoodScore = 0.0;

        for (Food food : foodList) {
            totalFoodScore += food.getFoodScore();
        }

        return totalFoodScore;
    }

    @Override
    public String toString() {
        return "Burrow{" +
                "foodList=" + foodList +
                '}';
    }
}
