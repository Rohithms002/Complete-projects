package com.tyss.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.taskmanagement.model.ToDoTask;

public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Integer> {

}
