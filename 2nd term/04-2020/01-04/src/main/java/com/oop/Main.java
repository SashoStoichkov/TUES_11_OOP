package main.java.com.oop;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Project project = new Project();
        Staff staff = new Staff("Pesho", "Peshev", Qualification.DEVELOPER);

        project.addStaff(staff);

        Epic epic1 = new Epic("Epic1");
        Story story11 = new Story("Story1.1", staff);
        Task task111 = new Task("Task1.1.1", staff);
        Task task112 = new Task("Task1.1.2", staff);
        Task task113 = new Task("Task1.1.3", staff);

        story11.addTask(task111);
        story11.addTask(task112);
        story11.addTask(task113);
        epic1.addStory(story11);

        Story story12 = new Story("Story1.2", staff);
        Task task121 = new Task("Task1.2.1", staff);
        Task task122 = new Task("Task1.2.2", staff);
        Task task123 = new Task("Task1.2.3", staff);

        story12.addTask(task121);
        story12.addTask(task122);
        story12.addTask(task123);
        epic1.addStory(story12);

        project.addEpic(epic1);

        Epic epic2 = new Epic("Epic2");
        Story story21 = new Story("Story2.1", staff);
        Task task211 = new Task("Task2.1.1", staff);
        Task task212 = new Task("Task2.1.2", staff);

        story21.addTask(task211);
        story21.addTask(task212);
        epic2.addStory(story21);
        project.addEpic(epic2);

        List<Story> stories = project.getAllStories(Status.WAITING, 1);
        for (Story story : stories) {
            System.out.println(story);
        }

        story21.setStatus(Status.IN_PROGRESS);

        stories = project.getAllStories(Status.IN_PROGRESS, 1);
        System.out.println(epic2);

        if (!stories.isEmpty()) {
            for (Story story : stories) {
                System.out.println(story);
            }
        } else {
            System.out.println("Empty!");
        }
    }
}
