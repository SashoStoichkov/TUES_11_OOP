package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class Story extends BaseType {
    private final Integer id;
    private String description = "";
    private Integer points = 0;
    private Staff assignee;
    private static Integer numberStories = 0;

    private Epic epic = null;
    private List<Task> taskList = new ArrayList<>();

    public Story(String name, Staff staff) {
        super(name);
        this.id = numberStories;
        this.assignee = staff;
        numberStories++;
    }

    public Integer getId() {
        return id;
    }

    public void setStatus(Status status) {
        if (epic != null) {
            if (status.equals(Status.IN_PROGRESS) && epic.getStatus().equals(Status.WAITING)) {
                epic.setStatus(status);
            }
        }

        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Staff getAssignee() {
        return assignee;
    }

    public void setAssignee(Staff assignee) {
        this.assignee = assignee;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", assignee=" + assignee +
                ", taskList=" + taskList +
                '}';
    }
}
