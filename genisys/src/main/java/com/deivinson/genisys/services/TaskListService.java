package com.deivinson.genisys.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.deivinson.genisys.dto.TaskListDTO;
import com.deivinson.genisys.entities.TaskList;
import com.deivinson.genisys.entities.User;
import com.deivinson.genisys.repositories.TaskListRepository;
import com.deivinson.genisys.repositories.UserRepository;

public class TaskListService {

	@Autowired
	private TaskListRepository repository;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	public TaskListDTO insertTask(TaskListDTO dto) {
		
		TaskList taskList = new TaskList();
		taskList.setTitle(dto.getTitle());
		taskList.setExpirationDate(dto.getExpirationDate());
		User user = usuarioRepository.findById(dto.getId())
	            .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
		taskList.setUser(user);

		repository.save(taskList);
		
		return new TaskListDTO(taskList);
	}
	
	
}
