package com.deivinson.genisys.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deivinson.genisys.dto.TaskListDTO;
import com.deivinson.genisys.services.TaskListService;

@RestController
@RequestMapping(value = "/tasklists")
public class TaskListController {

	@Autowired
	private TaskListService service;
	
	@PostMapping
	public ResponseEntity<TaskListDTO> insertTaskList(@RequestBody TaskListDTO dto){
		dto = service.insertTaskList(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
