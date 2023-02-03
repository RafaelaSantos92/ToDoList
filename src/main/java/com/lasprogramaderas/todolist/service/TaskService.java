package com.lasprogramaderas.todolist.service;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lasprogramaderas.todolist.model.Task;
import com.lasprogramaderas.todolist.repository.TaskRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
	
		
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
	
	public ResponseEntity<Task> updateTaskById(Task task, Long id){
		return taskrepository.findById(id)
				.map(taskToUpdate ->{
				taskToUpdate.setTitle(task.getTitle());
				taskToUpdate.setDescription(task.getDescription());
				taskToUpdate.setDeadLine(task.getDeadLine());
				Task updated = taskrepository.save(taskToUpdate);
				return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build()); 
	}
	
	public ResponseEntity<Object> deleteById(Long id){
		return taskrepository.findById(id)
				.map(taskToDelete ->{	
					taskrepository.deleteById(id);
					return ResponseEntity.noContent().build();
				}).orElse(ResponseEntity.notFound().build());
		
	}

}
