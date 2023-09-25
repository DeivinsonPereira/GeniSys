package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.Task;
import com.deivinson.listatarefas.entities.TaskList;
import com.deivinson.listatarefas.entities.User;

public class TaskDTOTest {

	private TaskDTO taskDTO;
	
	@BeforeEach
	public void setUp() {
		
		taskDTO = new TaskDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		taskDTO.setId(1L);
		assertEquals(1L, taskDTO.getId());
	}
	
	@Test
	public void testSetAndGetName() {
			
		taskDTO.setName("Bob");
		assertEquals("Bob", taskDTO.getName());
	}
	
	@Test
	public void testSetAndGetDescription() {
		
		taskDTO.setDescription("Testing the set and get methods for description.");
		assertEquals("Testing the set and get methods for description.", taskDTO.getDescription());
	}
	
	@Test
	public void testEstaCompleted() {
		
		taskDTO.setCompleted(true);
		
		assertTrue(taskDTO.isCompleted());
	}
	
	@Test
	public void testSetAndIsCompleted() {
		
		taskDTO.setCompleted(false);
		
		assertFalse(taskDTO.isCompleted());
	}
	
	@Test
	public void testEntityToDTOConversion() {
		
		TaskList taskList = new TaskList(1L, "Test", Instant.now(),new User(1L, "Joe", 30, "joe@gmail.com"));
		
		Task list = new Task (1L, "Exams","Prepare for the exam.",false, taskList);
		
		TaskDTO taskDTO = new TaskDTO(list);
		
		assertEquals(taskDTO.getId(), list.getId());
		assertEquals(taskDTO.getName(), list.getName());
		assertEquals(taskDTO.getDescription(), list.getDescription());
		assertEquals(taskDTO.isCompleted(), list.isCompleted());
		assertEquals(taskDTO.getTaskListDTO().getTitle(), list.getTaskList().getTitle());
	}
	
	@Test
	public void ConstructorWithArguments() {
		
		TaskListDTO taskListDTO = new TaskListDTO();
		
		TaskDTO taskDTO = new TaskDTO(1L, "Market", "Go shopping.", false, taskListDTO );
		
		assertNotNull(taskDTO);
		assertTrue(taskDTO.getId() == 1L);
	}
	
	@Test
	public void testSetters() {
		
		TaskListDTO taskListDTO = new TaskListDTO();
		
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setId(1L);
		taskDTO.setName("Market");
		taskDTO.setDescription("Go shopping.");
		taskDTO.setCompleted(false);
		taskDTO.setTaskListDTO(taskListDTO);
		
		assertNotNull(taskDTO);
		assertTrue(taskDTO.getId() == 1L);
	}
}
