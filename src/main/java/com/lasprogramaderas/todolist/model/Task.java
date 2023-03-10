package com.lasprogramaderas.todolist.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tasks")
@Getter @Setter
@ToString
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private String title;
		
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private Date deadLine;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable = false)
	private LocalDateTime createdAt;
	
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
}
