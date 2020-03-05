package main.java.com.oop;

public abstract class Food {
    String name;

    Food() {
        this("unknown food");
    }

    public Food(String name) {
        this.name = name;
    }

    abstract void print_nutritional_value();
}
