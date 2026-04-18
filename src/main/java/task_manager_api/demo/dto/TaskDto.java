package task_manager_api.demo.dto;

public class TaskDto {

    private String name;
    private Integer priority;

    public TaskDto(){}

    public TaskDto(String name, Integer priority){
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
