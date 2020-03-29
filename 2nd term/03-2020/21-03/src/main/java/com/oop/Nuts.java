package main.java.com.oop;

public class Nuts extends Food {
    public Nuts(Double quantity, Double quality) {
        super(quantity, quality);
        setName("nuts");
    }

    @Override
    public void passWinter() {
        setAge(getAge() + 1);
    }
}
