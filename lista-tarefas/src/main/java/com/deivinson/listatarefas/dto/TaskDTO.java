package com.deivinson.listatarefas.dto;

import com.deivinson.listatarefas.entities.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {

	private Long id;
	private String name;
	private String description;
	private boolean completed;
	
	private TaskListDTO taskListDTO;


	public TaskDTO(Long id, String name, String description, boolean completed, TaskListDTO taskList) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.taskListDTO = taskList;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.completed = entity.isCompleted();
		this.taskListDTO = new TaskListDTO(entity.getTaskList());
	}

}