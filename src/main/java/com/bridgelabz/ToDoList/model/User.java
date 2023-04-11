package com.bridgelabz.ToDoList.model;

import com.bridgelabz.ToDoList.dto.ToDoListDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private boolean completed;

    public String getName() {
        return name;
    }

    public User() {
    }

    public User(ToDoListDTO toDoListDTO) {
        this.name = toDoListDTO.name;
        this.description = toDoListDTO.description;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
