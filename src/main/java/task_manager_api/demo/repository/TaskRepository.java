package task_manager_api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_manager_api.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
}
