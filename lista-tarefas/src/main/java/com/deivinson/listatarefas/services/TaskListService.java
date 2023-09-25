package com.deivinson.listatarefas.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.deivinson.listatarefas.dto.TaskListDTO;
import com.deivinson.listatarefas.entities.TaskList;
import com.deivinson.listatarefas.entities.User;
import com.deivinson.listatarefas.repositories.TaskListRepository;
import com.deivinson.listatarefas.repositories.UserRepository;

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
