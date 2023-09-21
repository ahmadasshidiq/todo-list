package com.todolist.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {

    @Id
    private String id;

    @NotNull(message = "category id must not be null")
    private String categoryId;

    @NotNull(message = "description must not be null")
    private String description;

    @NotNull(message = "assignee must not be null")
    private String assignee;

    @NotNull(message = "status must not be null")
    private String status;

    private Category category;

}
