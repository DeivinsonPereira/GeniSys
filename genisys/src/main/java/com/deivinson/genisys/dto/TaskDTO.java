package com.deivinson.genisys.dto;

import com.deivinson.genisys.entities.Task;
import com.deivinson.genisys.entities.enums.TaskStatus;

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
	
	private TaskStatus status;
	private TaskListDTO taskListDTO;


	public TaskDTO(Long id, String name, TaskStatus status, String description, TaskListDTO taskList) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.taskListDTO = taskList;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.status = entity.getStatus();
		this.taskListDTO = new TaskListDTO(entity.getTaskList());
	}

}