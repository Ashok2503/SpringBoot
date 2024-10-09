package com.learning.todo.controller;

import com.learning.todo.model.ErrorMessage;
import com.learning.todo.model.Task;
import com.learning.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    ErrorMessage errorMessage;


    @GetMapping("/")
    public String greet() {
        return "Welcome to todo app ";
    }


    @GetMapping("/task-list")
    public List<Task> getListOfTask() {
        return taskService.getListOfTasks();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable int id) {
        Optional<Object> taskOptional = Optional.ofNullable(taskService.getTaskById(id));
        return taskOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task id is not found"));
    }

    @GetMapping("/task")
    public ResponseEntity<Object> getTaskByName(@RequestParam(required = false) String name) {
        Optional<Object> taskOptional = Optional.ofNullable(taskService.getTaskByName(name));
        return taskOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task is not found"));
    }


    @PostMapping("/task-add")
    public List<Task> addTaskToList(@RequestBody Task task) {
        return taskService.addTaskToList(task);
    }


}
