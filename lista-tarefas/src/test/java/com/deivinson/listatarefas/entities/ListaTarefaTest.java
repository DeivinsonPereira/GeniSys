package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaTarefaTest {
	
	private ListaTarefa listaTarefa;
	
	@BeforeEach
	public void setUp() {
		
		listaTarefa  = new ListaTarefa();
	}
	
	@Test
	public void testSetAndGetId() {
		
		listaTarefa.setId(1L);
		assertEquals(1L, listaTarefa.getId());
	}
	
	@Test
	public void testSetAndGetTitulo() {
			
		listaTarefa.setTitulo("Mercado");
		assertEquals("Mercado", listaTarefa.getTitulo());
	}

	@Test
	public void testSetAndGetVencimento() {
		
		Instant instanteEsperado = Instant.now();
		
		listaTarefa.setVencimento(instanteEsperado);
		
		assertEquals(instanteEsperado, listaTarefa.getVencimento());
	}
	
	@Test
	public void testEstaConcluida() {
		
		listaTarefa.setConcluida(true);
		
		assertTrue(listaTarefa.isConcluida());
	}
	
	@Test
	public void testSetAndIsConcluida() {
		
		listaTarefa.setConcluida(false);
		
		assertFalse(listaTarefa.isConcluida());
	}
	

}
