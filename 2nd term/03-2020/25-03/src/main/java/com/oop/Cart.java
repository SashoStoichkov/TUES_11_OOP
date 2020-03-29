package main.java.com.oop;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItemToCart(Item item, Integer amount) {
        if (item.hasID()) {
            items.put(item, items.get(item) + amount);
        } else {
            item.setID(Item.getNumberItems() - 1);
            items.put(item, amount);
        }
    }

    public Map<Item, Integer> checkoutCart() throws CartIsEmptyException {
        if (items.isEmpty()) {
            throw new CartIsEmptyException();
        } else {
            return items;
        }
    }
}
