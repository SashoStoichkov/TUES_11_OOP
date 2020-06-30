package main.java.com.oop.enums;

import java.util.HashMap;
import java.util.Map;

public enum Region {
    SOFIA, BURGAS, VARNA, PLOVDIV, RUSE, GABROVO, VIDIN, VRATSA;

    static Map<Region, Integer> carCounter = setUpCounter();

    private static Map<Region, Integer> setUpCounter() {
        Map<Region, Integer> map = new HashMap<>();

        map.put(SOFIA, -1);
        map.put(BURGAS, -1);
        map.put(VARNA, -1);
        map.put(PLOVDIV, -1);
        map.put(RUSE, -1);
        map.put(GABROVO, -1);
        map.put(VIDIN, -1);
        map.put(VRATSA, -1);

        return map;
    }

    public String getPrefix() {
        String prefix;

        switch (this) {
            case BURGAS -> prefix = "A";
            case SOFIA -> prefix = "CB";
            case VARNA -> prefix = "B";
            case VIDIN -> prefix = "BN";
            case VRATSA -> prefix = "BP";
            case GABROVO -> prefix = "EB";
            case PLOVDIV -> prefix = "PB";
            case RUSE -> prefix = "P";
            default -> throw new IllegalStateException("Unexpected value: " + this);
        }

        return prefix;
    }

    public static void incrementCounter(Region region) {
        carCounter.put(region, carCounter.get(region) + 1);
    }

    public static Integer getCounter(Region region) {
        return carCounter.get(region);
    }
}
