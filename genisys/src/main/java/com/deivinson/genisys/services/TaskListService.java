package com.deivinson.genisys.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deivinson.genisys.dto.TaskListDTO;
import com.deivinson.genisys.entities.TaskList;
import com.deivinson.genisys.entities.User;
import com.deivinson.genisys.entities.enums.TaskStatus;
import com.deivinson.genisys.repositories.TaskListRepository;
import com.deivinson.genisys.repositories.UserRepository;
import com.deivinson.genisys.services.exceptions.DatabaseException;
import com.deivinson.genisys.services.exceptions.ResourceNotFoundException;

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
		
		if (dto.getExpirationDate() != null) {
	        taskList.setExpirationDate(dto.getExpirationDate());
	    }
		
		User user = usuarioRepository.findById(dto.getUserDTO().getId())
	            .orElseThrow(() -> new EntityNotFoundException("User not found!"));
		taskList.setUser(user);
		taskList.setStatus(TaskStatus.UNFINISHED);
		taskList = repository.save(taskList);
		
		return new TaskListDTO(taskList);
	}
	
	@Transactional
    public TaskListDTO changeStatusTaskList(Long taskListId) {
        TaskList taskList = repository.findById(taskListId)
                .orElseThrow(() -> new EntityNotFoundException("TaskList not found!"));
        if(taskList.getStatus() == TaskStatus.UNFINISHED) {
        	taskList.setStatus(TaskStatus.COMPLETED);
        	taskList = repository.save(taskList);
        }else {
        	taskList.setStatus(TaskStatus.UNFINISHED);
        	taskList = repository.save(taskList);
        }
        return new TaskListDTO(taskList);
    }
	
	@Transactional
    public TaskListDTO updateTaskList(Long taskListId, TaskListDTO dto) {
        TaskList taskList = repository.findById(taskListId)
                .orElseThrow(() -> new EntityNotFoundException("TaskList not found!"));
        if(dto.getTitle() != null) {
        	taskList.setTitle(dto.getTitle());
        }
        if(dto.getExpirationDate() != null) {
        	taskList.setExpirationDate(dto.getExpirationDate());
        }
        
        taskList = repository.save(taskList);
        
        return new TaskListDTO(taskList);
    }
	
	@Transactional
	public void deleteTaskList(Long taskListId) {
		try {
			repository.deleteById(taskListId);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + taskListId);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
