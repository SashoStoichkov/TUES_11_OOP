package com.oop;

public class Rectangle {
    public Point p1;
    public Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getPerimeter() {
        double s1 = Math.abs(p1.x - p2.x);
        double s2 = Math.abs(p1.y - p2.y);

        return (s1 + s2) * 2;
    }

    public double getArea() {
        double s1 = Math.abs(p1.x - p2.x);
        double s2 = Math.abs(p1.y - p2.y);

        return s1*s2;
    }
}
