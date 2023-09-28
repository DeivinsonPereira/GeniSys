package com.deivinson.genisys.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deivinson.genisys.dto.TaskDTO;
import com.deivinson.genisys.dto.TaskListDTO;
import com.deivinson.genisys.services.TaskListService;
import com.deivinson.genisys.services.TaskService;

@RestController
@RequestMapping(value = "/tasklists")
public class TaskListController {

	@Autowired
	private TaskListService service;
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<TaskListDTO> insertTaskList(@RequestBody TaskListDTO dto){
		dto = service.insertTaskList(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PostMapping(value = "/{taskListId}/tasks" )
	public ResponseEntity<TaskDTO> insertTask(@PathVariable Long taskListId, @RequestBody TaskDTO dto){
		dto = taskService.insertTask(taskListId, dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{taskListId}/tasks/{taskId}")
    public ResponseEntity<TaskDTO> changeStatusTask(@PathVariable Long taskListId, @PathVariable Long taskId) {
		
        TaskDTO taskDTO = taskService.changeStatusTask(taskId);
        return ResponseEntity.ok(taskDTO);
    }
	
	@PutMapping(value = "/{taskListId}")
    public ResponseEntity<TaskListDTO> changeStatusTaskList(@PathVariable Long taskListId) {
		
		TaskListDTO taskListDTO = service.changeStatusTaskList(taskListId);
        return ResponseEntity.ok(taskListDTO);
    }

}
