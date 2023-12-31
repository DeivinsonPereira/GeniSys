package com.deivinson.genisys.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
}
