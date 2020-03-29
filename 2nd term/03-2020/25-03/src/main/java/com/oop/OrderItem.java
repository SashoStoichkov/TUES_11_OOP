package main.java.com.oop;

public class OrderItem {
    private final Item item;
    private final Double price;
    private final Integer quantity;

    public OrderItem(Item item, Double price, Integer quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }
}
