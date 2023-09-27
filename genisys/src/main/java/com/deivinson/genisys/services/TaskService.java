package com.deivinson.genisys.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deivinson.genisys.dto.TaskDTO;
import com.deivinson.genisys.entities.Task;
import com.deivinson.genisys.entities.TaskList;
import com.deivinson.genisys.entities.enums.TaskStatus;
import com.deivinson.genisys.repositories.TaskListRepository;
import com.deivinson.genisys.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private TaskListRepository taskListRepository;
	
	@Transactional
	public TaskDTO insertTask(Long taskListId, TaskDTO dto) {
		
		Task task = new Task();
		task.setName(dto.getName());
		task.setStatus(TaskStatus.UNFINISHED);
		task.setDescription(dto.getDescription());
		TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new EntityNotFoundException("TaskList not found with id: " + taskListId));
		
		task.setTaskList(taskList);
		
		task = repository.save(task);
		
		return new TaskDTO(task);
	}
}