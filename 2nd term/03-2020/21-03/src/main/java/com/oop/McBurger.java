package main.java.com.oop;

public class McBurger extends Food {
    public McBurger(Double quantity, Double quality) {
        super(quantity, quality);
        setName("mcburger");
    }

    @Override
    public void passWinter() {
        setAge(getAge() + 1);

        if (getAge() == 1) {
            setQuantity((double) Math.round((getQuantity() * 0.8) * 10.0) / 10.0);
            setQuality((double) Math.round((getQuality() * 0.5) * 10.0) / 10.0);
        }
    }
}
