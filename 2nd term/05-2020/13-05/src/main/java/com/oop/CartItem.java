package main.java.com.oop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CartItem {
    private final Product product;
    private Double quantity;
    private Set<DiscountItem> discountItems = new HashSet<>();

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 0.0;
    }

    public CartItem(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return product.getPrice() * quantity;
    }

    public void addDiscountItem(DiscountItem discountItem) {
        this.discountItems.add(discountItem);
    }

    public Double getFinalPrice() {
        Double discountPrice = discountItems.stream()
                .mapToDouble(discountItem -> {
                    Double amount = 0.0;
                    if (discountItem.getDiscountAmount().getAmountType().equals(Discount.DiscountAmount.AmountType.SUM)) {
                        amount = discountItem.getDiscountAmount().getAmount();
                    } else if (discountItem.getDiscountAmount().getAmountType().equals(Discount.DiscountAmount.AmountType.PERCENT)) {
                        amount = (discountItem.getDiscountAmount().getAmount() / 100) * getPrice();
                    }
                    return amount;
                }).sum();

        return getPrice() - discountPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(product.getName()).append("> / ").append(quantity).append(" / ").append(product.getPrice()).append(" / ").append(getPrice()).append("\n");
        for (DiscountItem discountItem : discountItems) {
            stringBuilder.append(discountItem.toString()).append("\n");
        }
        stringBuilder.append("--всичко / ").append(getFinalPrice()).append("\n");
        stringBuilder.append("---------------------------------------\n");
        return stringBuilder.toString();
    }
}
