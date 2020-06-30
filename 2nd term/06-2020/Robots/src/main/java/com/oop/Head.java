package main.java.com.oop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Head extends Module {
    private final List<Sensor> sensors;
    private final Boolean hasDeepVision;

    public Head(Robot robot, String serialNumber, List<Sensor> sensors) throws Robot.MaxNumberOfModulesReachedException, Robot.ModuleAlreadyExistsException {
        super(robot, ModuleType.HEAD, serialNumber);
        this.sensors = sensors;
        this.hasDeepVision = checkDeepVision(sensors);

        robot.addModule(this);
    }

    public Boolean getHasDeepVision() {
        return hasDeepVision;
    }

    private Boolean checkDeepVision(List<Sensor> sensors) {
        Map<Sensor, Integer> sensorMap = generateMap();
        sensors.forEach(sensor -> sensorMap.put(sensor, sensorMap.get(sensor) + 1));

        return sensorMap.containsValue(2);
    }

    private Map<Sensor, Integer> generateMap() {
        Map<Sensor, Integer> sensorMap = new HashMap<>();

        sensorMap.put(Sensor.CAMERA, 0);
        sensorMap.put(Sensor.IR, 0);
        sensorMap.put(Sensor.SOUND, 0);

        return sensorMap;
    }

    @Override
    public void processCommand(String command) {
        // TODO: 17.06.20 г.
    }

    @Override
    public Boolean isMinimumRequirementCovered(List<Module> modules) {
        return true;
    }

    @Override
    public String toString() {
        return "Head{" +
                "sensors=" + sensors +
                ", hasDeepVision=" + hasDeepVision +
                '}';
    }
}
