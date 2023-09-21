package com.todolist.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todolist.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
