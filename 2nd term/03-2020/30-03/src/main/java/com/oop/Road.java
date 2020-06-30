package main.java.com.oop;

public class Road {
    private final Integer ID;
    private final String name;
    private final Integer length;
    private final Integer city1ID;
    private final Integer city2ID;
    private static Integer numberRoads = 0;

    public Road(String name, Integer length, Integer city1ID, Integer city2ID) {
        this.ID = numberRoads;
        this.name = name;
        this.length = length;
        this.city1ID = city1ID;
        this.city2ID = city2ID;
        numberRoads++;
    }

    public String getName() {
        return name;
    }

    public Integer getLength() {
        return length;
    }
}
