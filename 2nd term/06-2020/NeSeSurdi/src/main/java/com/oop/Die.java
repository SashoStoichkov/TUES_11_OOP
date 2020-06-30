package main.java.com.oop;

import java.util.Random;

public class Die {
    public static Integer roll() {
        return new Random().nextInt(5) + 1;
    }
}
