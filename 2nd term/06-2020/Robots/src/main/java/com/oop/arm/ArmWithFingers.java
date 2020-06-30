package main.java.com.oop.arm;

import main.java.com.oop.Head;
import main.java.com.oop.exceptions.MinimumRequirementsNotCoveredException;
import main.java.com.oop.Module;
import main.java.com.oop.Robot;

import java.util.List;

public class ArmWithFingers extends Arm {
    public ArmWithFingers(Robot robot, String serialNumber, Integer numberOfJoints, Integer maxLoad) throws MinimumRequirementsNotCoveredException, Robot.MaxNumberOfModulesReachedException, Robot.ModuleAlreadyExistsException {
        super(robot, serialNumber, numberOfJoints, maxLoad);

        if (!isMinimumRequirementCovered(robot.getModules()))
            throw new MinimumRequirementsNotCoveredException("Arm with fingers cannot be added!");
        else
            robot.addModule(this);
    }

    @Override
    public void processCommand(String command) {
        // TODO: 17.06.20 г.
    }

    @Override
    public Boolean isMinimumRequirementCovered(List<Module> modules) {
        return modules.stream()
                .filter(module -> module instanceof Head && ((Head) module).getHasDeepVision())
                .count() >= 1;
    }
}
