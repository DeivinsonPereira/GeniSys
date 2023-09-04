package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.ListaTarefa;
import com.deivinson.listatarefas.entities.Tarefa;

public class TarefaDTOTest {

	private TarefaDTO tarefaDTO;
	
	private ListaTarefa	listaTarefa;
	
	@BeforeEach
	public void setUp() {
		
		tarefaDTO = new TarefaDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		tarefaDTO.setId(1L);
		assertEquals(1L, tarefaDTO.getId());
	}
	
	@Test
	public void testSetAndGetNome() {
			
		tarefaDTO.setNome("Bruno");
		assertEquals("Bruno", tarefaDTO.getNome());
	}
	
	@Test
	public void testSetAndGetDescricao() {
		
		TarefaDTO desc = tarefaDTO.setDescricao("Testando o set e get de descricao");
		assertEquals(desc, tarefaDTO.getDescricao());
	}
	
	@Test
	public void testEstaConcluida() {
		
		tarefaDTO.setConcluida(true);
		
		assertTrue(tarefaDTO.isConcluida());
	}
	
	@Test
	public void testSetAndIsConcluida() {
		
		tarefaDTO.setConcluida(false);
		
		assertFalse(tarefaDTO.isConcluida());
	}
	
	@Test
	public void testEntityToDTOConversion() {
		
		Tarefa lista = new Tarefa (1L, "Provas","Estudar para prova",false, new ListaTarefa(any(),"Teste",any(),any(),any(),any()));
		
		TarefaDTO listaTarefaDTO = new TarefaDTO(lista);
		
		assertEquals(listaTarefaDTO.getId(), lista.getId());
		assertEquals(listaTarefaDTO.getNome(), lista.getNome());
		assertEquals(listaTarefaDTO.getDescricao(), lista.getDescricao());
		assertEquals(listaTarefaDTO.isConcluida(), lista.isConcluida());
		assertEquals(listaTarefaDTO.getListaTarefa().getTitulo(), lista.getListaTarefa().getTitulo());
	}
}
