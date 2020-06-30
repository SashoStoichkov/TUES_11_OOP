package main.java.com.oop;

public class DiscountApplier {
    private final Cart cart;
    private final Discount discount;

    private boolean isApplicable(CartItem cartItem) {
        Product product = cartItem.getProduct();

        boolean categoryCondition = discount.getDiscountCondition().getCategories().contains(product.getCategory());
        boolean productCondition = discount.getDiscountCondition().getProducts().contains(product);

        if (!categoryCondition && !productCondition) return false;

        boolean amountCondition = discount.getDiscountCondition().getMinimumAmount() <= cartItem.getPrice();
        boolean quantityCondition = discount.getDiscountCondition().getMinimumQuantity() <= cartItem.getQuantity();

        return amountCondition && quantityCondition;
    }

    public DiscountApplier(Cart cart, Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public DiscountItem generateDiscountItems(CartItem cartItem) {
        return new DiscountItem(discount.getName(), discount.getDiscountAmount());
    }

    public void applyDiscount() {
        for (CartItem cartItem : cart.getCartItems()) {
            if (isApplicable(cartItem)) {
                cartItem.addDiscountItem(generateDiscountItems(cartItem));
            }
        }
    }

    public Double applyDiscountCart() {
        Double discountAmount = 0.0;

        if (cart.getCartItems().stream().anyMatch((this::isApplicable))) {
            discountAmount = cart.getDiscountOfCart(discount.getDiscountAmount());
        }

        return discountAmount;
    }
}
