package com.deivinson.genisys.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.genisys.entities.TaskList;
import com.deivinson.genisys.entities.User;

public class TaskListDTOTest {

	private TaskListDTO taskListDTO;
	
	private User user;
	
	@BeforeEach
	public void setUp() {
		
		taskListDTO = new TaskListDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		taskListDTO.setId(1L);
		assertEquals(1L, taskListDTO.getId());
	}
	
	@Test
	public void testSetAndGetInclusionDate() {
		
		Instant expectedInstant = Instant.now();
		
		taskListDTO.setInclusionDate(expectedInstant);
		
		assertEquals(expectedInstant, taskListDTO.getInclusionDate());
	}
	
	@Test
	public void testSetAndGetExpirationDate() {
		
		Instant instanteEsperado = Instant.now();
		
		taskListDTO.setExpirationDate(instanteEsperado);
		
		assertEquals(instanteEsperado, taskListDTO.getExpirationDate());
	}
	
	@Test
	public void testEstaCompleted() {
		
		taskListDTO.setCompleted(true);
		
		assertTrue(taskListDTO.isCompleted());
	}
	
	@Test
	public void testSetAndIsCompleted() {
		
		taskListDTO.setCompleted(false);
		
		assertFalse(taskListDTO.isCompleted());
	}
	
		
	@Test
	public void testEntityToDTOConversion() {
		
		
		user = new User(1L, "Joe", 30, "joe@gmail.com");
		
		TaskList taskList = new TaskList(1L, "teste", Instant.now(), user);
		
		TaskListDTO taskListDTO = new TaskListDTO(taskList);
		
		assertEquals(taskListDTO.getId(), taskList.getId());
		assertEquals(taskListDTO.getTitle(), taskList.getTitle());
		assertEquals(taskListDTO.getInclusionDate(), taskList.getInclusionDate());
		assertEquals(taskListDTO.isCompleted(), taskList.isCompleted());
		assertEquals(taskListDTO.getUserDTO().getName(), taskList.getUser().getName());
	}
	
	@Test
	public void constructorWithAllArguments() {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Joe");
		
		TaskListDTO taskListDTO = new TaskListDTO(1L, "Market",  Instant.now(), userDTO);
		
		assertEquals(1L, taskListDTO.getId());
		assertEquals("Market", taskListDTO.getTitle());
		assertEquals(Instant.now(), taskListDTO.getInclusionDate());
		assertEquals(Instant.now(), taskListDTO.getExpirationDate());
		assertFalse(taskListDTO.isCompleted() == true);
		assertEquals(userDTO.getName(), taskListDTO.getUserDTO().getName() );
		
	}
	
	@Test
	public void testSetter() {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Joe");
		
		TaskListDTO taskListDTO = new TaskListDTO();
		taskListDTO.setId(1L);
		taskListDTO.setTitle("Market");
		taskListDTO.setUserDTO(userDTO);
		
		assertEquals(1L, taskListDTO.getId());
		assertEquals("Market", taskListDTO.getTitle());
		assertEquals(userDTO.getName(), taskListDTO.getUserDTO().getName() );
	}

}
