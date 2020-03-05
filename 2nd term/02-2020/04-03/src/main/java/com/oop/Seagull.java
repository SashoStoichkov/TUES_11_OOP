package main.java.com.oop;

public class Seagull extends Bird implements ISwimmable, IWalkable, IFlyable{

    public Seagull(String name) {
        super(name);
    }

    @Override
    public void fly(Animal animal) {
        System.out.println(animal.name + " flies here.");
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
