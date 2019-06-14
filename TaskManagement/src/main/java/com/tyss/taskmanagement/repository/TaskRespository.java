package com.tyss.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.taskmanagement.model.Task;

public interface TaskRespository extends JpaRepository<Task, Integer>{
	

}
