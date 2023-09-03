package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		
		usuario = new Usuario();
	}
	
	@Test
	public void testSetAndGetId() {
		
		usuario.setId(1);
		assertEquals(1, usuario.getId());
	}
	
	@Test
	public void testSetAndGetNome() {
			
		usuario.setNome("Bruno");
		assertEquals("Bruno", usuario.getNome());
	}
	
	@Test
	public void testSetAndGetIdade() {
		
		usuario.setIdade(20);
		assertEquals(20, usuario.getIdade());
	}
	
	@Test
	public void testSetAndGetEmail() {
		
		usuario.setEmail("bruno@gmail.com");
		assertEquals("bruno@gmail.com", usuario.getEmail());
	}
}
