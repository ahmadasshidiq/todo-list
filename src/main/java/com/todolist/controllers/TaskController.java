package com.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.models.Task;
import com.todolist.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    // Untuk menampilkan tasks dengan category
    @GetMapping(path = "/detail-categories")
    public List<Task> getTaskWithCategory() {
        return service.getTaskWithCategory();
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/categories/{catId}")
    public List<Task> getByCategoryId(@PathVariable String catId) {
        return service.getByCategoryId(catId);
    }

    @GetMapping(path = "/categories/{catId}/status/{status}")
    public List<Task> getByStatusCategory(@PathVariable String catId, @PathVariable String status) {
        return service.getByStatusCategory(catId, status);
    }

    @GetMapping(path = "/{id}")
    public Task getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task insert(@RequestBody Task task) {
        return service.insert(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return service.update(task);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable String id) {
        return service.delete(id);
    }
}
