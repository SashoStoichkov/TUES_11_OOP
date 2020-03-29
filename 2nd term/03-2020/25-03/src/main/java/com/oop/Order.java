package main.java.com.oop;

import java.util.HashSet;
import java.util.Set;

public class Order {
    private final Integer ID;
    private final Integer userID;
    private final Address address;
    private Status status;
    private Set<OrderItem> orderItems;
    private static Integer numberOrders = 0;

    public Order(Integer userID, Address address, Status status) {
        this.ID = numberOrders;
        this.userID = userID;
        this.address = address;
        this.status = status;
        this.orderItems = new HashSet<>();
        numberOrders++;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addOrderItem(Item item, Double price, Integer quantity) {
        orderItems.add(new OrderItem(item, price, quantity));
    }

    public Integer getID() {
        return ID;
    }

    public Address getAddress() {
        return address;
    }
}
