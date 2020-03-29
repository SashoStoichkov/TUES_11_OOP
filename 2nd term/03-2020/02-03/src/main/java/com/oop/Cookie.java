package main.java.com.oop;

public class Cookie extends Food implements IBakeable, IFryable{

    Cookie() {
        super("Cookie");
    }

    public Cookie(String name) {
        super(name);
    }

    @Override
    void print_nutritional_value() {
        System.out.println("I have some calories.");
    }

    @Override
    public void bake(Skara bbq) {
        System.out.println("Baking the " + name + "...");
    }


    @Override
    public void fry(Skara bbq) {
        System.out.println("Frying the " + name + "...");
    }
}
