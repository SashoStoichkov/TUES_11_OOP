package main.java.com.oop.arm;

import main.java.com.oop.Module;
import main.java.com.oop.ModuleType;
import main.java.com.oop.Robot;

import java.util.List;

public abstract class Arm extends Module {
    private final Integer numberOfJoints;
    private final Integer maxLoad;

    public Arm(Robot robot, String serialNumber, Integer numberOfJoints, Integer maxLoad) {
        super(robot, ModuleType.ARM, serialNumber);
        this.numberOfJoints = numberOfJoints;
        this.maxLoad = maxLoad;
    }

    @Override
    public abstract void processCommand(String command);

    @Override
    public abstract Boolean isMinimumRequirementCovered(List<Module> modules);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "numberOfJoints=" + numberOfJoints +
                ", maxLoad=" + maxLoad +
                '}';
    }
}
