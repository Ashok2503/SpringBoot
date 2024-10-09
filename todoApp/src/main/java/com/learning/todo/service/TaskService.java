package com.learning.todo.service;


import com.learning.todo.model.Task;
import com.learning.todo.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepo repo;

    public List<Task> getListOfTasks() {
        return repo.findAll();
    }

    public List<Task> addTaskToList(Task task) {
         repo.save(task);
         return getListOfTasks();
    }

    public Task getTaskById(int id) {
        return repo.findById(String.valueOf(id)).orElse(null);
    }

    public Object getTaskByName(String name) {
        return repo.findByName(name);
    }
}
