package cfs.tasktracker.entity;

import jakarta.persistence.Entity;

import java.util.List;

public class ListTask {
    private List<Task> tasks;

    public ListTask(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
