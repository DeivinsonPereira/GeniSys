package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.User;

public class UserDTOTest {

	private UserDTO usuarioDTO;
	
	@BeforeEach
	public void setUp() {
		
		usuarioDTO = new UserDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		usuarioDTO.setId(1L);
		assertEquals(1L, usuarioDTO.getId());
	}
	
	@Test
	public void testSetAndGetNome() {
			
		usuarioDTO.setNome("Bruno");
		assertEquals("Bruno", usuarioDTO.getNome());
	}
	
	@Test
	public void testSetAndGetEmail() {
		
		usuarioDTO.setEmail("bruno@gmail.com");
		assertEquals("bruno@gmail.com", usuarioDTO.getEmail());
	}
	
	@Test
	public void testEntityToDTOConversion() {
		
		User usuario = new User (1L, "João", 30, "joao@gmail.com");
		
		UserDTO usuarioDTO = new UserDTO(usuario);
		
		assertEquals(usuario.getId(), usuarioDTO.getId());
		assertEquals(usuario.getNome(), usuarioDTO.getNome());
		assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
	}
	
	@Test
	public void ConstructorWithArguments() {
		
		UserDTO usuarioDTO = new UserDTO(1L, "João", "joao@gmail.com");
		
		assertEquals(1L, usuarioDTO.getId());
		assertEquals("João", usuarioDTO.getNome());
		assertEquals("joao@gmail.com", usuarioDTO.getEmail());
	}
	
}
