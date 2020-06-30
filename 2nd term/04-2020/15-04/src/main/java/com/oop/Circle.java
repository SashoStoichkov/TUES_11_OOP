package main.java.com.oop;

public class Circle implements Shape {
    private final Point center;
    private final Double radius;

    public Circle(Point center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public Double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public boolean containsPoint(Point point) {
        return Point.distance(point, center) <= radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
