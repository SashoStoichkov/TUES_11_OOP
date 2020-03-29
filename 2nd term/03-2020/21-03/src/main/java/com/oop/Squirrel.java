package main.java.com.oop;

public class Squirrel {
    private final String name;
    private final String type;
    private Integer age;

    private Burrow burrow;

    private Integer foodFound = 0;
    private final Integer maxFoodPerYear = 4;

    public Squirrel(String name, String type, Integer age) {
        this.name = name;
        this.type = type;
        this.age = age;
        burrow = new Burrow();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return '<' + type + "> " + name + '(' + age + ')';
    }

    public Integer getFoodFound() {
        return foodFound;
    }

    public Integer getMaxFoodPerYear() {
        return maxFoodPerYear;
    }

    public void addFood(Food food) throws NoMoreFoodException {
        if (foodFound + 1 <= maxFoodPerYear) {
            foodFound++;
            burrow.addFood(food);

            if (foodFound.equals(maxFoodPerYear)) {
                throw new NoMoreFoodException();
            }
        } else {
            throw new NoMoreFoodException();
        }
    }

    public void passWinter() {
        burrow.passWinter();
        foodFound = 0;
        age++;
    }

    public Double getTotalFoodScore() {
        return burrow.getTotalFoodScore();
    }

    public String getBurrowString() {
        return burrow.toString();
    }
}
