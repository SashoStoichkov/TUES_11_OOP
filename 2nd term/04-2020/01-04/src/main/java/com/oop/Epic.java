package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class Epic extends BaseType {
    private final Integer id;
    private String description = "";
    private static Integer numberEpics = 0;

    private List<Story> storyList = new ArrayList<>();

    public Epic(String name) {
        super(name);
        this.id = numberEpics;
        numberEpics++;
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

    public List<Story> getStoryList() {
        return storyList;
    }

    public void addStory(Story story) {
        story.setEpic(this);
        this.storyList.add(story);
    }

    public List<Story> getAllStories(Status status) {
        List<Story> stories = new ArrayList<>();

        for (Story story : storyList) {
            if (story.getStatus().equals(status)) {
                stories.add(story);
            }
        }

        return stories;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
