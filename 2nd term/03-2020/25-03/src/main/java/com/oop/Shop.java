package main.java.com.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Shop {
    private Map<Item, Integer> stockProducts;
    private final Country country;
    private final Set<Country> deliverCountries;
    private Cart cart;
    private Map<Integer, Order> orders;
    private Map<Customer, Boolean> customers;
    private Order order;

    public Shop(Country country, Set<Country> deliverCountries) {
        this.stockProducts = new HashMap<>();
        this.country = country;
        this.deliverCountries = deliverCountries;
        this.cart = new Cart();
        this.orders = new HashMap<>();
        this.customers = new HashMap<>();
    }

    public void registerCustomer(Customer customer) {
        for (Map.Entry<Customer, Boolean> entry : customers.entrySet()) {
            entry.setValue(false);
        }

        customers.put(customer, true);
    }

    public void addItem(Item item, Integer amount) {
        if (item.hasID()) {
            stockProducts.put(item, stockProducts.get(item) + amount);
        } else {
            item.setID(Item.getNumberItems() - 1);
            stockProducts.put(item, amount);
        }
    }

    public void removeItem(Item item, Integer amount) throws ItemNotFoundException, TooBigAmountException {
        if (stockProducts.containsKey(item)) {
            if (amount < stockProducts.get(item)) {
                stockProducts.put(item, stockProducts.get(item) - amount);
            } else if (amount.equals(stockProducts.get(item))) {
                stockProducts.remove(item);
            } else {
                throw new TooBigAmountException();
            }
        } else {
            throw new ItemNotFoundException();
        }
    }

    public void addItemToCart(Item item, Integer amount) {
        cart.addItemToCart(item, amount);
    }

    private Integer getActiveUserID() {
        Integer activeID = null;

        for (Map.Entry<Customer, Boolean> entry : customers.entrySet()) {
            if (entry.getValue()) {
                activeID = entry.getKey().getID();
            }
        }

        return activeID;
    }

    private Address getActiveUserAddress() {
        Address activeAddress = null;

        for (Map.Entry<Customer, Boolean> entry : customers.entrySet()) {
            if (entry.getValue()) {
                activeAddress = entry.getKey().getAddress();
            }
        }

        return activeAddress;
    }

    public void checkoutCart() throws CartIsEmptyException, TooBigAmountException {
        Map<Item, Integer> activeCart = cart.checkoutCart();

        for (Map.Entry<Item, Integer> entry : activeCart.entrySet()) {
            for (Map.Entry<Item, Integer> entry1 : stockProducts.entrySet()) {
                if (entry.getValue() > entry1.getValue()) {
                    throw new TooBigAmountException();
                }
            }
        }

        order = new Order(getActiveUserID(), getActiveUserAddress(), Status.OPEN);
        orders.put(order.getID(), order);
    }

    public void shipOrder(Integer ID) throws UnknownCountryException, UnknownOrderIDException {
        if (orders.containsKey(ID)) {
            if (deliverCountries.contains(orders.get(ID).getAddress().getCountry())) {
                orders.get(ID).setStatus(Status.SHIPPED);
            } else {
                failOrder(ID);
                throw new UnknownCountryException();
            }
        } else {
            throw new UnknownOrderIDException();
        }
    }

    public void completeOrder(Integer ID) throws UnknownOrderIDException {
        if (orders.containsKey(ID)) {
            orders.get(ID).setStatus(Status.COMPLETED);
        } else {
            throw new UnknownOrderIDException();
        }
    }

    public void failOrder(Integer ID) throws UnknownOrderIDException {
        if (orders.containsKey(ID)) {
            orders.get(ID).setStatus(Status.FAILED);
        } else {
            throw new UnknownOrderIDException();
        }
    }
}
