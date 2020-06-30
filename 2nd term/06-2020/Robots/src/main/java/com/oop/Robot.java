package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final String name;
    private final String serialNumber;
    private Integer currentNumberOfModules;
    private final Integer maxNumberOfModules;
    private List<Module> modules;

    public Robot(String name, String serialNumber, Integer maxNumberOfModules) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.currentNumberOfModules = 0;
        this.maxNumberOfModules = maxNumberOfModules;
        this.modules = new ArrayList<>();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) throws MaxNumberOfModulesReachedException, ModuleAlreadyExistsException {
        if (currentNumberOfModules + 1 > maxNumberOfModules) throw new MaxNumberOfModulesReachedException();

        else if (modules.contains(module)) throw new ModuleAlreadyExistsException();

        else {
            modules.add(module);
            currentNumberOfModules++;
        }
    }

    public static class MaxNumberOfModulesReachedException extends Exception {
        public MaxNumberOfModulesReachedException() {
            super("You have reached maximum number of modules for this robot!");
        }
    }

    public static class ModuleAlreadyExistsException extends Exception {
        public ModuleAlreadyExistsException() {
            super("Module already exists!");
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", currentNumberOfModules=" + currentNumberOfModules +
                ", modules=" + modules +
                '}';
    }
}
