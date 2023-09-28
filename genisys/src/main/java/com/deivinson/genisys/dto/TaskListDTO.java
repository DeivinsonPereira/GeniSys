package com.deivinson.genisys.dto;

import java.time.Instant;

import com.deivinson.genisys.entities.TaskList;
import com.deivinson.genisys.entities.enums.TaskStatus;

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
	private TaskStatus status;
	
	private UserDTO userDTO;
	
	public TaskListDTO(Long id, String title, TaskStatus status, Instant expirationDate, UserDTO userDTO) {
		this.id = id;
		this.title = title;
		this.inclusionDate = Instant.now();
		this.expirationDate = expirationDate;
		this.status = status;
		this.userDTO = userDTO;
	}
	
	public TaskListDTO(TaskList entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.inclusionDate = Instant.now();
		this.expirationDate = entity.getExpirationDate();
		this.status = entity.getStatus();
		this.userDTO = new UserDTO(entity.getUser());
		
	}

}
