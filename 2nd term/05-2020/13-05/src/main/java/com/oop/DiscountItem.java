package main.java.com.oop;

public class DiscountItem {
    private final String name;
    private final Discount.DiscountAmount discountAmount;

    public DiscountItem(String name, Discount.DiscountAmount discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    public String getName() {
        return name;
    }

    public Discount.DiscountAmount getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        return "-<" + name + "> / отстъпка " + discountAmount.toString();
    }
}
