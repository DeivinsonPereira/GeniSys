package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.User;

public class UserDTOTest {

	private UserDTO userDTO;
	
	@BeforeEach
	public void setUp() {
		
		userDTO = new UserDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		userDTO.setId(1L);
		assertEquals(1L, userDTO.getId());
	}
	
	@Test
	public void testSetAndGetName() {
			
		userDTO.setName("Bob");
		assertEquals("Bob", userDTO.getName());
	}
	
	@Test
	public void testSetAndGetEmail() {
		
		userDTO.setEmail("bob@gmail.com");
		assertEquals("bob@gmail.com", userDTO.getEmail());
	}
	
	@Test
	public void testEntityToDTOConversion() {
		
		User user = new User (1L, "Joe", 30, "joe@gmail.com");
		
		UserDTO userDTO = new UserDTO(user);
		
		assertEquals(user.getId(), userDTO.getId());
		assertEquals(user.getName(), userDTO.getName());
		assertEquals(user.getEmail(), userDTO.getEmail());
	}
	
	@Test
	public void ConstructorWithArguments() {
		
		UserDTO userDTO = new UserDTO(1L, "Joe", "joe@gmail.com");
		
		assertEquals(1L, userDTO.getId());
		assertEquals("Joe", userDTO.getName());
		assertEquals("joe@gmail.com", userDTO.getEmail());
	}
	
}
