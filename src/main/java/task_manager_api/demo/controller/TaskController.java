package task_manager_api.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task_manager_api.demo.dto.TaskDto;
import task_manager_api.demo.exception.ErrorResponse;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody TaskDto dto) {
        return taskService.create(dto.getName(), dto.getPriority());
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) throws TaskNotFoundException{
        taskService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody TaskDto dto) throws TaskNotFoundException{
        taskService.update(id,dto.getName(), dto.getPriority());
    }
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(TaskNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }
}
