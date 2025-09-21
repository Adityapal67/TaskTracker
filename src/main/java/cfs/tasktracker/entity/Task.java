package cfs.tasktracker.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100,nullable = false)
    private String description;

    @Column(length = 100,nullable = false)
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public Task(String description, String status, LocalDateTime createdAt, LocalDateTime completedAt) {
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }
    public Task() {}

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

}
