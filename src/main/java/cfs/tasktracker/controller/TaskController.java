package cfs.tasktracker.controller;

import cfs.tasktracker.entity.Task;
import cfs.tasktracker.repo.TaskRepository;
import cfs.tasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok().body(taskService.findAllTask());
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
      return ResponseEntity.ok(taskService.createTask(task));
    }

    @PatchMapping("/update/{id}/{status}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@PathVariable String status){
        Task task = taskService.updateTaskStatusById(id,status);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable String status){
        return ResponseEntity.ok().body(taskService.findTaskByStatus(status));
    }

}
