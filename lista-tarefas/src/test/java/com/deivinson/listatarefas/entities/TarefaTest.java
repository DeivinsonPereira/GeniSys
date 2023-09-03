package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TarefaTest {

	private Tarefa tarefa;
	
	@BeforeEach
	public void setUp() {
		
		tarefa = new Tarefa();
	}
	
	@Test
	public void testSetAndGetId() {
		
		tarefa.setId(1);
		assertEquals(1, tarefa.getId());
	}
	
	@Test
	public void testSetAndGetTitulo() {
			
		tarefa.setTitulo("Mercado");
		assertEquals("Mercado", tarefa.getTitulo());
	}
	
	@Test
	public void testSetAndGetDescricao() {
		
		tarefa.setDescricao("Comprar arroz");
		assertEquals("Comprar arroz", tarefa.getDescricao());
	}
	
	@Test
	public void testSetAndGetDataInclusao() {
		
		Instant instanteEsperado = Instant.now();
		
		tarefa.setDataInclusao(instanteEsperado);
		
		assertEquals(instanteEsperado, tarefa.getDataInclusao());
	}
	
	@Test
	public void testSetAndGetVencimento() {
		
		Instant instanteEsperado = Instant.now();
		
		tarefa.setVencimento(instanteEsperado);
		
		assertEquals(instanteEsperado, tarefa.getVencimento());
	}
	
	@Test
	public void testEstaConcluida() {
		
		boolean tarefaConcluida = tarefa.SetConcluida(true);
		
		assertTrue(tarefaConcluida);
	}
	
	@Test
	public void testSetAndIsConcluida() {
		
		tarefa.setConcluida(false);
		
		boolean naoEstaConcluida = tarefa.isConcluida();
		
		assertFalse(naoEstaConcluida);
	}
}
