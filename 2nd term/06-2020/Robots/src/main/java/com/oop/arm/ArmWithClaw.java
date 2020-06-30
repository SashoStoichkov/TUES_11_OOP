package main.java.com.oop.arm;

import main.java.com.oop.Module;
import main.java.com.oop.Robot;

import java.util.List;

public class ArmWithClaw extends Arm {
    public ArmWithClaw(Robot robot, String serialNumber, Integer numberOfJoints, Integer maxLoad) {
        super(robot, serialNumber, numberOfJoints, maxLoad);
    }

    @Override
    public void processCommand(String command) {
        // TODO: 17.06.20 г.
    }

    @Override
    public Boolean isMinimumRequirementCovered(List<Module> modules) {
        return true;
    }
}
