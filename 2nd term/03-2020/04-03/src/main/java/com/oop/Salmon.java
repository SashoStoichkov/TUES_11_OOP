package main.java.com.oop;

public class Salmon extends Fish implements ISwimmable{
    public Salmon(String name) {
        super(name);
    }

    @Override
    public void swim(Animal animal) {
        System.out.println(animal.name + " swims here.");
    }
}
