package com.bridgelabz.ToDoList.repository;

import com.bridgelabz.ToDoList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IToDoListRepo extends JpaRepository<User, Integer> {
}
