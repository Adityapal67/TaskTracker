package cfs.tasktracker.service;

import cfs.tasktracker.entity.Task;
import cfs.tasktracker.repo.TaskRepository;
import ch.qos.logback.core.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        Task task1 = new Task();
        task1.setDescription(task.getDescription());
        task1.setStatus(task.getStatus());
        return  taskRepository.save(task1);
    }
    public Task updateTaskStatusById(Long id, String status) {
        Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public List<Task> findAllTask()
    {
        return taskRepository.findAll();
    }
    public List<Task> findTaskByStatus(String status)
    {
        return taskRepository.findByStatus(status);
    }
    public void deleteTask(Long id)
    {
     Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
     taskRepository.delete(task);
    }

}
