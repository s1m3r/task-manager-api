package task_manager_api.demo.service;

import task_manager_api.demo.exception.TaskNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import task_manager_api.demo.model.Task;
import org.springframework.stereotype.Service;
import task_manager_api.demo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(String name, Integer priority) {
        Task task = new Task(name,priority);
        return repository.save(task);
    }

    public List<Task> readAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) throws TaskNotFoundException {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Task getById(Integer id) throws TaskNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }


    public void update(Integer id, String name, Integer priority) throws TaskNotFoundException {
        Task task = getById(id);
        task.setName(name);
        task.setPriority(priority);
        repository.save(task);
    }
}
