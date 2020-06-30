package main.java.com.oop;

public class Resource {
    private final Position position;
    private Integer quantity;

    public Resource(Position position, Integer quantity) {
        this.position = position;
        this.quantity = quantity;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isEmpty() {
        return quantity.equals(0);
    }
}
