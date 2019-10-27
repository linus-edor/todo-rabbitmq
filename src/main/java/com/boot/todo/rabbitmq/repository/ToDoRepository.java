package com.boot.todo.rabbitmq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.todo.rabbitmq.model.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, String> {
}