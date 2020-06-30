package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Double getDiscountOfCart(Discount.DiscountAmount discountAmount) {
        Double total = 0.0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getPrice();
        }

        Double discount = 0.0;

        if (discountAmount.getAmountType().equals(Discount.DiscountAmount.AmountType.SUM)) {
            discount = discountAmount.getAmount();
        } else if (discountAmount.getAmountType().equals(Discount.DiscountAmount.AmountType.PERCENT)) {
            discount = (discountAmount.getAmount()/100) * total;
        }

        return discount;
    }
}
