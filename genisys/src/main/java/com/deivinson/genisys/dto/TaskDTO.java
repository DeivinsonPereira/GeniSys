package com.deivinson.genisys.dto;

import com.deivinson.genisys.entities.Task;

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
		this.completed = false;
		this.taskListDTO = taskList;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.completed = false;
		this.taskListDTO = new TaskListDTO(entity.getTaskList());
	}

}