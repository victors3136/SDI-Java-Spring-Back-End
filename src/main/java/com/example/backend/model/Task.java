package com.example.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@SuppressWarnings("unused")
@Entity
public class Task implements HasId, Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotNull(message = "Description must not be null")
    private String description;

    @Max(value = 10, message = "Priority must be between 1 and 10")
    @Min(value = 1, message = "Priority must be between 1 and 10")
    private byte priority;

    @NotNull(message = "Due date must not be null")
    private Instant dueDate;

    public Task(String name, String description, byte priority, Instant dueDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Task() {

    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "{\"id\":\"%s\", \"name\":\"%s\", \"description\":\"%s\", \"priority\":\"%s\", \"dueDate\":\"%s\"}".formatted(id, name, description, priority, dueDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return getId() == task.getId();
    }

    public boolean validationFails() {
        return (name == null) ||
                (name.isEmpty()) ||
                (description == null) ||
                (priority < 1) ||
                (priority > 10) ||
                (dueDate == null);
    }

}