package main.java.com.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private List<Staff> staff;
    private Map<Integer, Epic> epics;

    public Project() {
        this.staff = new ArrayList<>();
        this.epics = new HashMap<>();
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public Map<Integer, Epic> getEpics() {
        return epics;
    }

    public void addEpic(Epic epic) {
        this.epics.put(epic.getId(), epic);
    }

    public List<Story> getAllStories(Status status) {
        List<Story> stories = new ArrayList<>();

        for (Epic epic : epics.values()) {
            stories.addAll(epic.getAllStories(status));
        }

        return stories;
    }

    public List<Story> getAllStories(Status status, Integer epicId) throws Exception {
        if (epics.containsKey(epicId)) {
            return epics.get(epicId).getAllStories(status);
        } else {
            throw new Exception("epicID not found!");
        }
    }
}
