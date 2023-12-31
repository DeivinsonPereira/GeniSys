package com.deivinson.genisys.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

	private Task task;
	
	@BeforeEach
	public void setUp() {
		
		task = new Task();
	}
	
	@Test
	public void testSetAndGetId() {
		
		task.setId(1L);
		assertEquals(1L, task.getId());
	}
	
	@Test
	public void testSetAndGetName() {
			
		task.setName("Market");
		assertEquals("Market", task.getName());
	}
	
	@Test
	public void testSetAndGetDescription() {
		
		task.setDescription("Buy rice");
		assertEquals("Buy rice", task.getDescription());
	}
	
}
