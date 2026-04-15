package task_manager_api.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private int priority;
    private int id;
    private List<String> tags = new ArrayList<>();

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(String name, int priority, int id) {
        this.name = name;
        this.priority = priority;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }
}
