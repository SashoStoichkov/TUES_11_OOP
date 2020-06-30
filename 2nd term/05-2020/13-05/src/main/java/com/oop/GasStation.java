package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    private List<Discount> discounts = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();

    public GasStation() {
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProductToCart(Product product, Double quantity) {
        cart.addItem(new CartItem(product, quantity));
    }

    public String checkOut() {
        for (Discount discount : discounts) {
            DiscountApplier discountApplier = new DiscountApplier(cart, discount);
            discountApplier.applyDiscount();
        }

        return Receipt.printReceipt(cart);
    }
}
