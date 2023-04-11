package com.bridgelabz.ToDoList.controller;

import com.bridgelabz.ToDoList.dto.ToDoListDTO;
import com.bridgelabz.ToDoList.model.User;
import com.bridgelabz.ToDoList.repository.IToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoList {

    @Autowired
    private IToDoListRepo iToDoListRepo;

    @GetMapping("/")
    public String message() {
        return "Hello World!";
    }

    @PostMapping("/Create")
    public User CreateUser(@RequestBody ToDoListDTO toDoListDTO) {

        User userData = new User(toDoListDTO);
        return iToDoListRepo.save(userData);
    }

    @GetMapping("/Get/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        Optional<User> userData = iToDoListRepo.findById(id);
        if (userData.isPresent()) {
            return userData;
        }
        return null;
    }

    @GetMapping("/DisplayAll")
    public List<User> DisplayAll() {
        return iToDoListRepo.findAll();

    }

    @PutMapping("/Edit/{id}")
    public User EditUser(@RequestBody ToDoListDTO toDoListDTO, @PathVariable int id) {
        Optional<User> userData = iToDoListRepo.findById(id);
        if (userData.isPresent()) {
            userData.get().setName(toDoListDTO.name);
            userData.get().setDescription(toDoListDTO.description);
            return iToDoListRepo.save(userData.get());
        }
        return null;
    }

    @DeleteMapping("/Delete/{id}")
    public String deleteUserData(@PathVariable int id) {
        Optional<User> userData = iToDoListRepo.findById(id);
        if (userData.isPresent()) {
            iToDoListRepo.deleteById(id);
            return "Data Delete successfully ";
        }
        return "id not found";
    }

    @DeleteMapping("/DeleteAll")
    public String deleteAllUser() {
        iToDoListRepo.deleteAll();
        return "Delete All successfully ";
    }
}