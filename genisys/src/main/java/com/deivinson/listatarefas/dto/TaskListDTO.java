package com.deivinson.listatarefas.dto;

import java.time.Instant;

import com.deivinson.listatarefas.entities.TaskList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskListDTO {

	private Long id;
	private String title;
	private Instant inclusionDate;
	private Instant expirationDate;
	private boolean completed;
	
	private UserDTO userDTO;
	
	public TaskListDTO(Long id, String title, Instant expirationDate, UserDTO userDTO) {
		this.id = id;
		this.title = title;
		this.inclusionDate = Instant.now();
		this.expirationDate = expirationDate;
		this.completed = false;
		this.userDTO = userDTO;
	}
	
	public TaskListDTO(TaskList entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.inclusionDate = entity.getInclusionDate();
		this.expirationDate = entity.getExpirationDate();
		this.completed = entity.isCompleted();
		this.userDTO = new UserDTO(entity.getUser());
		
	}

}
