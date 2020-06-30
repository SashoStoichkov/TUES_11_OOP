package main.java.com.oop;

import java.util.List;

public abstract class Module {
    private final Robot robot;
    private final ModuleType moduleType;
    private final String serialNumber;

    private final String moduleId;
    private static Integer id = 0;

    public Module(Robot robot, ModuleType moduleType, String serialNumber) {
        this.robot = robot;
        this.moduleType = moduleType;
        this.serialNumber = serialNumber;

        id++;
        this.moduleId = this.getClass().getSimpleName() + "_" + id.toString();
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModuleId() {
        return moduleId;
    }

    public abstract void processCommand(String command);
    public abstract Boolean isMinimumRequirementCovered(List<Module> modules);

    @Override
    public abstract String toString();
}
