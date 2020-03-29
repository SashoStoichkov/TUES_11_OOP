package main.java.com.oop;

public class Cake extends Food {
    public Cake(Double quantity, Double quality) {
        super(quantity, quality);
        setName("cake");
    }

    @Override
    public void passWinter() {
        setAge(getAge() + 1);
        setQuantity((double) Math.round((getQuantity() * 0.7) * 10.0) / 10.0);
        setQuality((double) Math.round((getQuality() * (0.1 + 1.99 / Math.pow(2, (getAge() / 0.85)))) * 1000.0) / 1000.0);
    }
}
