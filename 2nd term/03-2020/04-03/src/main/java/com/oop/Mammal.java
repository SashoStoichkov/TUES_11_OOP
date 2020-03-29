package main.java.com.oop;

public abstract class Mammal extends Animal{
    public Mammal(String name) {
        super(name);
    }

    public void giveBirth(){
        System.out.println(name + " is born.");
    }
}
