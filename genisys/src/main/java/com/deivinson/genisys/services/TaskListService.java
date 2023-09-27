package com.deivinson.genisys.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deivinson.genisys.dto.TaskListDTO;
import com.deivinson.genisys.entities.TaskList;
import com.deivinson.genisys.entities.User;
import com.deivinson.genisys.repositories.TaskListRepository;
import com.deivinson.genisys.repositories.UserRepository;

@Service
public class TaskListService {

	@Autowired
	private TaskListRepository repository;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	@Transactional
	public TaskListDTO insertTaskList(TaskListDTO dto) {
		
		TaskList taskList = new TaskList();
		taskList.setTitle(dto.getTitle());
		taskList.setExpirationDate(dto.getExpirationDate());
		
		User user = usuarioRepository.findById(dto.getUserDTO().getId())
	            .orElseThrow(() -> new EntityNotFoundException("User not found!"));
		taskList.setUser(user);

		taskList = repository.save(taskList);
		
		return new TaskListDTO(taskList);
	}
	
	
	
}
