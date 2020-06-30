package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Resource> resources;
    private List<Worker> workers;
    private Integer currResourceCount;

    public Simulation(List<Resource> resources, List<Worker> workers) {
        this.resources = resources;
        this.workers = workers;
        this.currResourceCount = 0;
    }

    public void run() {
        List<Resource> fullResources = new ArrayList<>();

        for (Resource resource : resources) {
            if (!resource.isEmpty()) {
                fullResources.add(resource);
            }
        }

        for (Worker worker : workers) {
            worker.nextTick();
            currResourceCount += worker.getCurrResourceCount();
            worker.findNewResource(fullResources);
        }
    }
}
