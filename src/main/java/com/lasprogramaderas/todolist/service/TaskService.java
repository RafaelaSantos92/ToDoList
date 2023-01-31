package com.lasprogramaderas.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lasprogramaderas.todolist.model.Task;
import com.lasprogramaderas.todolist.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskrepository;
	
	
	public Task createTask(Task task) {
		return taskrepository.save(task);
	}
	
	public List<Task> listAllTasks(){
		return taskrepository.findAll();
	}
	
	public ResponseEntity<Task> findTaskById(Long id){
		return taskrepository.findById(id)
				.map(task -> ResponseEntity.ok().body(task))
				.orElse(ResponseEntity.notFound().build());
	}

}
