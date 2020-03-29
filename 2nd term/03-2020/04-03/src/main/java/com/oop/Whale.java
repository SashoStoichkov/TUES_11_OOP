package main.java.com.oop;

public class Whale extends Mammal implements ISwimmable{
    public Whale(String name) {
        super(name);
    }

    @Override
    public void swim(Animal animal) {
        System.out.println(animal.name + " swims here.");
    }
}
