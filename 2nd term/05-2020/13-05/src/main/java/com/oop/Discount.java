package main.java.com.oop;

public class Discount {
    public enum DiscountType {
        QUANTITY, PRICE
    }

    public enum DiscountTarget {
        PRODUCT, CART
    }

    public static class DiscountAmount {
        public enum AmountType {
            PERCENT, SUM
        }

        private final AmountType amountType;
        private final Double amount;

        public DiscountAmount(AmountType amountType, Double amount) {
            this.amountType = amountType;
            this.amount = amount;
        }

        public AmountType getAmountType() {
            return amountType;
        }

        public Double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            if (amountType.equals(AmountType.SUM)) {
                return amount + "лв.";
            }
            return amount + "%";
        }
    }

    private final String code;
    private final String name;
    private final DiscountType discountType;
    private final DiscountAmount discountAmount;
    private final DiscountTarget discountTarget;
    private final DiscountCondition discountCondition;

    public Discount(String code, String name, DiscountType discountType, DiscountAmount discountAmount, DiscountTarget discountTarget, DiscountCondition discountCondition) {
        this.code = code;
        this.name = name;
        this.discountType = discountType;
        this.discountAmount = discountAmount;
        this.discountTarget = discountTarget;
        this.discountCondition = discountCondition;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public DiscountAmount getDiscountAmount() {
        return discountAmount;
    }

    public DiscountTarget getDiscountTarget() {
        return discountTarget;
    }

    public DiscountCondition getDiscountCondition() {
        return discountCondition;
    }
}
