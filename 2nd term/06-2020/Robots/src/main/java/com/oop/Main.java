package main.java.com.oop;

import main.java.com.oop.arm.ArmWithFingers;
import main.java.com.oop.exceptions.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot("Pesho", "pesho1", 3);

        try {
            new Head(robot, "hand_1", Arrays.asList(Sensor.CAMERA, Sensor.CAMERA, Sensor.IR));
        } catch (Robot.MaxNumberOfModulesReachedException | Robot.ModuleAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            new ArmWithFingers(robot, "finger_arm_1", 10, 600);
        } catch (MinimumRequirementsNotCoveredException | Robot.MaxNumberOfModulesReachedException | Robot.ModuleAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(robot);
    }
}
