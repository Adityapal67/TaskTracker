package cfs.tasktracker.repo;

import cfs.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
   List<Task> findByStatus(String status);
    Optional<Task> findById(Long id);
}