package main.java.com.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements Shape {
    private final Point A;
    private final Point B;
    private final Point C;

    public Triangle(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }

    @Override
    public Double getArea() {
        double ab = Point.distance(A, B);
        double bc = Point.distance(C, B);
        double ac = Point.distance(A, C);
        double p = (ab + bc + ac) / 2;

        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
    }

    @Override
    public boolean containsPoint(Point point) {
        Triangle triangle1 = new Triangle(A, B, point);
        Triangle triangle2 = new Triangle(C, B, point);
        Triangle triangle3 = new Triangle(A, C, point);

        BigDecimal triangle1Area = BigDecimal.valueOf(triangle1.getArea()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal triangle2Area = BigDecimal.valueOf(triangle2.getArea()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal triangle3Area = BigDecimal.valueOf(triangle3.getArea()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal thisArea = BigDecimal.valueOf(this.getArea()).setScale(2, RoundingMode.HALF_UP);

        return triangle1Area.add(triangle2Area).add(triangle3Area).equals(thisArea);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
