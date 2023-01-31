package com.lasprogramaderas.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lasprogramaderas.todolist.model.Task;
import com.lasprogramaderas.todolist.service.TaskService;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
	
	
	@Autowired
	TaskService taskservice;
	
	
	@PostMapping("/tasks")
	@ResponseStatus(HttpStatus.CREATED)
	public Task createTask(@RequestBody Task task) {
		return taskservice.createTask(task);
	}
	
	@GetMapping("/tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks(){
		return taskservice.listAllTasks();
	}
	
	@GetMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id){
		return taskservice.findTaskById(id);
	}
}