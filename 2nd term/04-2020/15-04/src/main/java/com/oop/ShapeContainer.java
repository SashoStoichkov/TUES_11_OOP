package main.java.com.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeContainer <T extends Shape> {
    private List<T> shapesList;

    public ShapeContainer() {
        this.shapesList = new ArrayList<>();
    }

    public void add(T shape) {
        shapesList.add(shape);
    }

    public List<T> getAllByArea(Integer area) {
        List<T> resultShapeList = new ArrayList<>();

        for (T shape : shapesList) {
            if (shape.getArea().equals(area)) {
                resultShapeList.add(shape);
            }
        }

        return resultShapeList;
    }

    public Double getTotalArea() {
        Double totalArea = 0.0;

        for (T shape : shapesList) {
            totalArea += shape.getArea();
        }

        return totalArea;
    }

    public List<T> getAllContaining(Point point) {
        List<T> resultContainingShapes = new ArrayList<>();

        for (T shape : shapesList) {
            if (shape.containsPoint(point)) {
                resultContainingShapes.add(shape);
            }
        }

        return resultContainingShapes;
    }

    public void orderDescending() {
        shapesList.sort((o1, o2) -> Double.compare(o2.getArea(), o1.getArea()));
    }
}
