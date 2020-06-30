package main.java.com.oop;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();

        Product benzin = new Product("Бензин", "benzin", 2.19, Unit.L, Category.FUEL);
        Product qdki = new Product("Ядки", "qdki", 5.00, Unit.BR, Category.FOOD);

        gasStation.addProduct(benzin);
        gasStation.addProduct(qdki);

        gasStation.addProductToCart(benzin, 20.0);
        gasStation.addProductToCart(qdki, 5.0);

        DiscountCondition benzinDiscountCondition = new DiscountCondition(0d, 10d);
        benzinDiscountCondition.setCategories(new HashSet<>(Collections.singleton(Category.FUEL)));

        DiscountCondition cartDiscountCondition = new DiscountCondition(20d, 0d);
        cartDiscountCondition.setCategories(new HashSet<>(Collections.singleton(Category.FOOD)));

        Discount benzinDiscount = new Discount("benzin_dis",
                "Бензин над 10л", Discount.DiscountType.QUANTITY,
                new Discount.DiscountAmount(Discount.DiscountAmount.AmountType.PERCENT, 5d),
                Discount.DiscountTarget.PRODUCT, benzinDiscountCondition);

        Discount cartDiscount = new Discount("cart_dis",
                "Ядки над 20лв", Discount.DiscountType.PRICE,
                new Discount.DiscountAmount(Discount.DiscountAmount.AmountType.PERCENT, 10d),
                Discount.DiscountTarget.PRODUCT, cartDiscountCondition);

        gasStation.addDiscount(benzinDiscount);
        gasStation.addDiscount(cartDiscount);
        System.out.println(gasStation.checkOut());
    }
}
