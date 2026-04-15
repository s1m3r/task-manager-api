package task_manager_api.demo.controller;
import org.springframework.web.bind.annotation.*;
import task_manager_api.demo.exception.TaskNotFoundException;
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

    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id) throws TaskNotFoundException {
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) throws TaskNotFoundException{
        taskService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Task task) throws TaskNotFoundException{
        taskService.update(id,task.getName(), task.getPriority());
    }
}
