package task_manager_api.demo.model;

/*import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;*/
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer priority;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    public Task() {
    }

    public Task(String name, Integer priority){
        this.name = name;
        this.priority = priority;
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

    /*public Task(String name, Integer priority, Integer id) {
        this.name = name;
        this.priority = priority;
        this.id = id;
    }
*/
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
