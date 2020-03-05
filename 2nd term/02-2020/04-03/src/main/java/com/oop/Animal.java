package main.java.com.oop;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    void sayName(){
        System.out.println("My name is " + name);
    }
}
