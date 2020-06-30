package main.java.com.oop;

import java.util.HashSet;
import java.util.Set;

public class DiscountCondition {
    private Set<Category> categories = new HashSet<>();
    private Set<Product> products = new HashSet<>();

    private final Double minimumAmount;
    private final Double minimumQuantity;

    public DiscountCondition(Double minimumAmount, Double minimumQuantity) {
        this.minimumAmount = minimumAmount;
        this.minimumQuantity = minimumQuantity;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public Double getMinimumQuantity() {
        return minimumQuantity;
    }
}
