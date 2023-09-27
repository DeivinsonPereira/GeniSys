package com.deivinson.genisys.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

	private User user;
	
	@BeforeEach
	public void setUp() {
		
		user = new User();
	}
	
	@Test
	public void testSetAndGetId() {
		
		user.setId(1L);
		assertEquals(1L, user.getId());
	}
	
	@Test
	public void testSetAndGetName() {
			
		user.setName("Bruno");
		assertEquals("Bruno", user.getName());
	}
	
	@Test
	public void testSetAndGetAge() {
		
		user.setAge(20);
		assertEquals(20, user.getAge());
	}
	
	@Test
	public void testSetAndGetEmail() {
		
		user.setEmail("bob@gmail.com");
		assertEquals("bob@gmail.com", user.getEmail());
	}
}
