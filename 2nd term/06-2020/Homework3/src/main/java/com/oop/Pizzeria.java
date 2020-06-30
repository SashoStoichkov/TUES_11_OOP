package main.java.com.oop;

import main.java.com.oop.exceptions.InvalidIngredientTypeException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Pizzeria {
    private BlockingQueue<Order> ordersForPreparation;
    private BlockingQueue<Order> ordersForBaking;
    private ExecutorService pizzaiolos;
    private Map<String, Ingredient> ingredientMap;
    private Set<Stoves> stoves;

    private final FileWriter fileWriter;
    private final Object logLock = new ReentrantLock();

    public Pizzeria() throws IOException {
        this.stoves = new HashSet<>();
        this.ingredientMap = new HashMap<>();
        this.ordersForBaking = new LinkedBlockingQueue<>();
        this.ordersForPreparation = new LinkedBlockingQueue<>();
        this.pizzaiolos = Executors.newCachedThreadPool();
        this.fileWriter = new FileWriter("pizzeria.txt");
    }

    public void log(String logMessage) throws IOException {
        synchronized (logLock) {
            fileWriter.write(logMessage + "\n");
            fileWriter.flush();
        }
    }

    public void addOrder(Order order) throws InterruptedException {
       ordersForPreparation.put(order);
    }

    public void addPizzaiolo(Pizzaiolo pizzaiolo) {
        pizzaiolos.submit(pizzaiolo);
     }

    public void addStoves(Stoves stoves) {
        this.stoves.add(stoves);
    }

    public void addIngredient(String ingredientName, IngredientType ingredientType) throws InvalidIngredientTypeException {
        ingredientMap.put(ingredientName, new Ingredient(ingredientName, ingredientType));
    }

    public Map<String, Ingredient> getIngredientMap() {
        return ingredientMap;
    }

    public BlockingQueue<Order> getOrdersForPreparation() {
        return ordersForPreparation;
    }

    public BlockingQueue<Order> getOrdersForBaking() {
        return ordersForBaking;
    }

    public void shutDown() {
        try {
            pizzaiolos.shutdownNow();

            for (Stoves stoves : stoves) {
                stoves.shutDown();
            }
        } catch (NullPointerException ignored) {
        }
    }
}
