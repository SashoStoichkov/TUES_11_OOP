package main.java.com.oop;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stoves {
    private final Pizzeria pizzeria;
    private final ExecutorService stoveExecutor;
    private final Integer capacity;

    private static Integer id = 0;
    private final Integer stoveId;

    public Stoves(Pizzeria pizzeria, Integer capacity) {
        this.pizzeria = pizzeria;
        this.capacity = capacity;
        stoveExecutor = Executors.newFixedThreadPool(capacity);
        this.stoveId = id++;

        for (int i = 0; i < capacity; i++) {
            stoveExecutor.submit(new Stove());
        }
    }

    public void shutDown() {
        stoveExecutor.shutdownNow();
    }

    public class Stove implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Order order = pizzeria.getOrdersForBaking().take();

                    String date = String.valueOf(new Timestamp(new Date().getTime()));
                    String sId = String.valueOf(Thread.currentThread().getId() + stoveId);

                    pizzeria.log(date + " | Stove " + sId + " took " + order + " to bake!");

                    Thread.sleep((long) (timeForBaking(order.getIngredients()) * 1000));

                    date = String.valueOf(new Timestamp(new Date().getTime()));
                    pizzeria.log(date + " | Stove " + sId + " finished baking " + order + "! Buon appetito! :)");
                } catch (InterruptedException | IOException e) {
                    break;
                }
            }
        }

        private Double timeForBaking(List<Ingredient> ingredients) {
            Double total = 0d;
            Set<IngredientType> types = new HashSet<>();

            for (Ingredient ingredient : ingredients) {
                if (types.contains(ingredient.getIngredientType())) {
                    total += ingredient.getTimeForBaking() / 10;
                } else {
                    total += ingredient.getTimeForBaking();
                    types.add(ingredient.getIngredientType());
                }
            }

            return total;
        }
    }

    @Override
    public String toString() {
        return "Stoves{ " + capacity + " }";
    }
}
