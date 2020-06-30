package main.java.com.oop;

import java.util.List;

public class Worker extends BaseUnit {
    private final Integer maxResourceCount;
    private Integer currResourceCount = 0;

    private Resource currResource;

    private Position dropPosition;
    private Position targetPosition;
    private Integer direction;

    public Worker(String name, Integer speed, Position position, Integer maxPoints, Integer maxResourceCount, Position dropPosition) {
        super(name, speed, position, maxPoints);
        this.maxResourceCount = maxResourceCount;
        this.dropPosition = dropPosition;
    }

    public Integer getMaxResourceCount() {
        return maxResourceCount;
    }

    public Integer getCurrResourceCount() {
        return currResourceCount;
    }

    public void setCurrResourceCount(Integer currResourceCount) {
        this.currResourceCount = currResourceCount;
    }

    public Resource getCurrResource() {
        return currResource;
    }

    public void setCurrResource(Resource currResource) {
        this.currResource = currResource;
    }

    public Position getDropPosition() {
        return dropPosition;
    }

    public void setDropPosition(Position dropPosition) {
        this.dropPosition = dropPosition;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }

    @Override
    public void nextTick() {
        if (currResourceCount.equals(0)) {
            targetPosition = currResource.getPosition();
            this.move();
            if (this.getPosition().equals(targetPosition)) {
                if (currResource.getQuantity() >= maxResourceCount) {
                    currResourceCount = maxResourceCount;
                    currResource.setQuantity(currResource.getQuantity() - maxResourceCount);
                } else {
                    currResourceCount += currResource.getQuantity();
                    currResource.setQuantity(0);
                }
            } else {
                this.nextTick();
            }
        } else {
            targetPosition = dropPosition;
            this.move();
            if (this.getPosition().equals(targetPosition)) {
                this.currResourceCount = 0;
            } else {
                this.nextTick();
            }
        }
    }

    public void findNewResource(List<Resource> resources) {
        if (currResource.getQuantity().equals(0)) {
            for (Resource resource : resources) {
//                todo: to finish this
            }
        }
    }
}
