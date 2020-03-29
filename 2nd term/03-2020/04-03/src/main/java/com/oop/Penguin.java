package main.java.com.oop;

public class Penguin extends Bird implements IWalkable, ISwimmable{
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void swim(Animal animal) {
        System.out.println(animal.name + " swims here.");
    }

    @Override
    public void walk(Animal animal) {
        System.out.println(animal.name + " walks here.");
    }
}
