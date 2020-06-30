package main.java.com.oop;

public class Test <T extends Number> {
    int size;
    private T item;

    public Test(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    static <S> void fn(S arg) {
        System.out.println(arg);
    }
}
