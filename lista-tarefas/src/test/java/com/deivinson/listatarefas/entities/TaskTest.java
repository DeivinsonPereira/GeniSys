package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

	private Task tarefa;
	
	@BeforeEach
	public void setUp() {
		
		tarefa = new Task();
	}
	
	@Test
	public void testSetAndGetId() {
		
		tarefa.setId(1L);
		assertEquals(1L, tarefa.getId());
	}
	
	@Test
	public void testSetAndGetNome() {
			
		tarefa.setNome("Mercado");
		assertEquals("Mercado", tarefa.getNome());
	}
	
	@Test
	public void testSetAndGetDescricao() {
		
		tarefa.setDescricao("Comprar arroz");
		assertEquals("Comprar arroz", tarefa.getDescricao());
	}
	
	@Test
	public void testEstaConcluida() {
		
		tarefa.setConcluida(true);
		
		assertTrue(tarefa.isConcluida());
	}
	
	@Test
	public void testSetAndIsConcluida() {
		
		tarefa.setConcluida(false);
		
		assertFalse(tarefa.isConcluida());
	}
}
