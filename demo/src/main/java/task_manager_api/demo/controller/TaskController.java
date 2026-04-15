package task_manager_api.demo.controller;
import org.springframework.web.bind.annotation.*;
import task_manager_api.demo.model.Task;
import task_manager_api.demo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    // Конструктор (Spring сам сюда подставит TaskService)
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE
    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task.getName(), task.getPriority());
    }

    // GET ALL
    @GetMapping
    public List<Task> getAll() {
        return taskService.readAll();
    }
}
