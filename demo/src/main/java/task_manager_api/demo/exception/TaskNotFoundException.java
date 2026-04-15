package task_manager_api.demo.exception;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException(int id) {
        super("Task with id " + id + " not found");
    }
}

