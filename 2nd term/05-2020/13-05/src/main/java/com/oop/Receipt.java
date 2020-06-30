package main.java.com.oop;

import java.util.Date;

public class Receipt {
    public static String printReceipt(Cart cart) {
        Double total = 0.0;
        StringBuilder receiptString = new StringBuilder();

        receiptString.append("=======================================\n");
        receiptString.append("Date: ").append(new Date().toString()).append("\n");
        receiptString.append("=======================================\n");
        receiptString.append("Продукт / Количество / Ед. цена / Общо\n");
        receiptString.append("=======================================\n");
        for (CartItem cartItem : cart.getCartItems()) {
            receiptString.append(cartItem.toString());
            total += cartItem.getFinalPrice();
        }

        receiptString.append("Тотал / ").append(total).append("\n");
        return receiptString.toString();
    }
}
