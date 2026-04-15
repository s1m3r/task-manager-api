package task_manager_api.demo.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private Integer priority;
    private Integer id;
    private List<String> tags = new ArrayList<>();

    public Task() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task(String name, Integer priority, Integer id) {
        this.name = name;
        this.priority = priority;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getId() {
        return id;
    }
}
