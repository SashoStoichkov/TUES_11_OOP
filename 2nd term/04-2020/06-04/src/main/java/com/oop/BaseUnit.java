package main.java.com.oop;

public abstract class BaseUnit {
    private final String name;
    private Integer speed;
    private Position position;
    private Integer maxPoints;
    private Integer currPoints = 0;

    public BaseUnit(String name, Integer speed, Position position, Integer maxPoints) {
        this.name = name;
        this.speed = speed;
        this.position = position;
        this.maxPoints = maxPoints;
    }

    public String getName() {
        return name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public Integer getCurrPoints() {
        return currPoints;
    }

    public void setCurrPoints(Integer currPoints) {
        this.currPoints = currPoints;
    }

    public void move() {
        this.position.setX(this.position.getX() + this.speed);
        this.position.setY(this.position.getY() + this.speed);
    }

    public abstract void nextTick();
}
