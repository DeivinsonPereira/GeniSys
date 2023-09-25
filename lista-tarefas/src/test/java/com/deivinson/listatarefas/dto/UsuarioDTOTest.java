package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.Usuario;

public class UsuarioDTOTest {

	private UsuarioDTO usuarioDTO;
	
	@BeforeEach
	public void setUp() {
		
		usuarioDTO = new UsuarioDTO();
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
		
		Usuario usuario = new Usuario (1L, "João", 30, "joao@gmail.com");
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		
		assertEquals(usuario.getId(), usuarioDTO.getId());
		assertEquals(usuario.getNome(), usuarioDTO.getNome());
		assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
	}
	
	@Test
	public void ConstructorWithArguments() {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L, "João", "joao@gmail.com");
		
		assertEquals(1L, usuarioDTO.getId());
		assertEquals("João", usuarioDTO.getNome());
		assertEquals("joao@gmail.com", usuarioDTO.getEmail());
	}
	
}
