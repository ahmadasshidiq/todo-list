package com.todolist.services;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.models.Category;
import com.todolist.models.Task;
import com.todolist.repositories.CategoryRepository;
import com.todolist.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private CategoryRepository repoCat;

    // insert repo
    public Task insert(Task task) {
        task.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    // findAll repo
    public List<Task> getAll() {
        return repository.findAll();
    }

    // get by id repo
    public Task getById(String id) {
        return repository.findById(id).get();
    }

    // get by category id repo
    public List<Task> getByCategoryId(String catId) {
        return repository.findByCategory(catId);
    }

    // get by category id and status repo
    public List<Task> getByStatusCategory(String catId, String status) {
        return repository.findByCategoryAndStatus(catId, status);
    }

    // update repo
    public Task update(Task task) {
        Task ts = repository.findById(task.getId()).get();
        ts.setCategoryId(task.getCategoryId());
        ts.setAssignee(task.getAssignee());
        ts.setDescription(task.getDescription());
        ts.setStatus(task.getStatus());
        return repository.save(ts);
    }

    // delete repo
    public String delete(String id) {
        repository.deleteById(id);
        return "task " + id + " succesfully deleted";
    }

    // get task with categories
    public List<Task> getTaskWithCategory() {
        List<Task> dataTask = repository.findAll();
        List<Category> dataCat = repoCat.findAll();

        // Mengambil data category dari koleksi "categories" berdasarkan categoryId
        Map<String, Category> categoryMap = dataCat.stream()
                .collect(Collectors.toMap(Category::getId, category -> category));

        dataTask.forEach(task -> {
            Category cat = categoryMap.get(task.getCategoryId());
            task.setCategory(cat);
        });

        return dataTask;
    }

}
