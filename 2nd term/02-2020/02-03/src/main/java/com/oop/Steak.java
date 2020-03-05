package main.java.com.oop;

public class Steak implements IBakeable{

    @Override
    public void bake(Skara bbq) {
        System.out.println("Baking the steak...");
    }
}
