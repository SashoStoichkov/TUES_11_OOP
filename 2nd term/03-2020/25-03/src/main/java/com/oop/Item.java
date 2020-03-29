package main.java.com.oop;

import java.util.Objects;

public class Item {
    private Integer ID;
    private final String name;
    private final Double price;
    private final Unit unit;
    private static Integer numberItems = 0;

    public Item(String name, Double price, Unit unit) throws NotFullInfoException {
        this.name = name;
        this.price = price;
        this.unit = unit;
        validate();
        numberItems++;
    }

    public Item(Integer ID, String name, Double price, Unit unit) throws NotFullInfoException {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.unit = unit;
        validate();
        numberItems++;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public static Integer getNumberItems() {
        return numberItems;
    }

    void validate() throws NotFullInfoException {
        if (name == null || name.trim().equals("")) {
            throw new NotFullInfoException("Product name");
        }

        if (price == null) {
            throw new NotFullInfoException("Product price");
        }

        if (unit == null) {
            throw new NotFullInfoException("Unit");
        }
    }

    public boolean hasID() {
        return ID != null && ID >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(ID, item.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
