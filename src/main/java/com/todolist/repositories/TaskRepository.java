package com.todolist.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.todolist.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

    @Query("{ categoryId: ?0 }")
    List<Task> findByCategory(String catId);

    @Query("{ categoryId: ?0, status: ?1 }")
    List<Task> findByCategoryAndStatus(String catId, String status);

}
