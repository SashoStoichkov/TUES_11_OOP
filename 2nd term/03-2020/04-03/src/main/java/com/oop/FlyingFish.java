package main.java.com.oop;

public class FlyingFish extends Fish implements ISwimmable, IFlyable{
    public FlyingFish(String name) {
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
}
