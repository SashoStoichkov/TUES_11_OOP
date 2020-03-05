package main.java.com.oop;

public class Cat extends Mammal implements IWalkable, ISwimmable{

    public Cat(String name) {
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
