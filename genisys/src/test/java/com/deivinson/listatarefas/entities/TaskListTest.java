package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskListTest {
	
	private TaskList taskList;
	
	@BeforeEach
	public void setUp() {
		
		taskList  = new TaskList();
	}
	
	@Test
	public void testSetAndGetId() {
		
		taskList.setId(1L);
		assertEquals(1L, taskList.getId());
	}
	
	@Test
	public void testSetAndGetTitle() {
			
		taskList.setTitle("Market");
		assertEquals("Market", taskList.getTitle());
	}

	@Test
	public void testSetAndGetExpirationDate() {
		
		Instant expectedInstant = Instant.now();
		
		taskList.setExpirationDate(expectedInstant);
		
		assertEquals(expectedInstant, taskList.getExpirationDate());
	}
	
	@Test
	public void testEstaCompleted() {
		
		taskList.setCompleted(true);
		
		assertTrue(taskList.isCompleted());
	}
	
	@Test
	public void testSetAndIsCompleted() {
		
		taskList.setCompleted(false);
		
		assertFalse(taskList.isCompleted());
	}

}
