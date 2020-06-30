package main.java.com.oop;

public enum Category {
    FUEL("fuel_code", "Fuel"), FOOD("food_code", "Food"), OTHER("other_code", "Other");

    private final String code;
    private final String name;

    Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
