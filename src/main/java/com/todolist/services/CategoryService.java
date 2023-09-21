package com.todolist.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.models.Category;
import com.todolist.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    // insert repo
    public Category insert(Category cat) {
        cat.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(cat);
    }

    // findAll repo
    public List<Category> getAll() {
        return repository.findAll();
    }

    // get by id repo
    public Category getById(String id) {
        return repository.findById(id).get();
    }

    // update repo
    public Category update(Category cat) {
        Category category = repository.findById(cat.getId()).get();
        category.setName(cat.getName());

        return repository.save(category);
    }

    // delete repo
    public String delete(String id) {
        repository.deleteById(id);
        return "category " + id + " succesfully deleted";
    }

}
