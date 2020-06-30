package main.java.com.oop;

public class Task extends BaseType {
    private final Integer id;
    private String description = "";
    private Staff assignee;
    private static Integer numberTasks = 0;

    public Task(String name, Staff staff) {
        super(name);
        this.id = numberTasks;
        this.assignee = staff;
        numberTasks++;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Staff getAssignee() {
        return assignee;
    }

    public void setAssignee(Staff assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", assignee=" + assignee +
                '}';
    }
}
