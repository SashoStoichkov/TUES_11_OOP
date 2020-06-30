package main.java.com.oop;

public class Rectangle implements Shape {
    private final Point lowerLeft;
    private final Point upperRight;

    public Rectangle(Point lowerLeft, Point upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    public Point getLowerLeft() {
        return lowerLeft;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    @Override
    public Double getArea() {
        return (upperRight.getY() - lowerLeft.getY()) * (upperRight.getX() - lowerLeft.getX());
    }

    @Override
    public boolean containsPoint(Point point) {
        return (lowerLeft.getX() <= point.getX() && point.getX() <= upperRight.getX()) &&
               (lowerLeft.getY() <= point.getY() && point.getY() <= upperRight.getY());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "lowerLeft=" + lowerLeft +
                ", upperRight=" + upperRight +
                '}';
    }
}
