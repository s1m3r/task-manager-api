package task_manager_api.demo.service;
import org.springframework.web.bind.annotation.RequestBody;
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

@Service
public class TaskService {
    private Map<Integer, Task> tasks = new ConcurrentHashMap();
    private AtomicInteger nextId = new AtomicInteger(1);
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public TaskService() {
    }


    public Task create(String name, Integer priority) {
        int id = this.nextId.getAndIncrement();
        Task task = new Task(name, priority, id);
        this.tasks.put(id, task);
        return task;
    }

    public Future<Task> createAsync(String name, Integer priority) {
        return this.executor.submit(() -> {
            return this.create(name, priority);
        });
    }

    public void shutdown() throws InterruptedException {
        this.executor.shutdown();
        this.executor.awaitTermination(1L, TimeUnit.SECONDS);
    }

    public List<Task> readAll() {
        return new ArrayList(this.tasks.values());
    }

    public void deleteById(Integer id) throws TaskNotFoundException {
        Task removed = (Task)this.tasks.remove(id);
        if (removed == null) {
            throw new TaskNotFoundException(id);
        }
    }

    public Task getById(Integer id) throws TaskNotFoundException {
        Task task = (Task)this.tasks.get(id);
        if (task == null) {
            throw new TaskNotFoundException(id);
        } else {
            return task;
        }
    }

    public void update(Integer id, String name, Integer priority) throws TaskNotFoundException {
        Task task = this.getById(id);
        task.setName(name);
        task.setPriority(priority);
    }
}
