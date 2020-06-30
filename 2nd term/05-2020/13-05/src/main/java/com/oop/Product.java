package main.java.com.oop;

public class Product {
    private final String name;
    private final String code;
    private final Double price;
    private final Unit unit;
    private final Category category;

    public Product(String name, String code, Double price, Unit unit, Category category) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.unit = unit;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public Unit getUnit() {
        return unit;
    }

    public Category getCategory() {
        return category;
    }
}
