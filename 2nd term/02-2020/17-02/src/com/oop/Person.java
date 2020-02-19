package com.oop;

public class Person {
    public static char gender = 'F';
    private static int count = 0;

    public static int getCount() {
        return count;
    }
    public static void increment() {
        count++;
    }

    public String name;
    private int age;

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        Person.increment();
    }

    public Person() {
        this("Iliana", 17);
    }
}
