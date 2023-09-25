package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.ListaTarefa;
import com.deivinson.listatarefas.entities.Tarefa;
import com.deivinson.listatarefas.entities.Usuario;

public class TarefaDTOTest {

	private TarefaDTO tarefaDTO;
	
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
		
		tarefaDTO.setDescricao("Testando o set e get de descricao");
		assertEquals("Testando o set e get de descricao", tarefaDTO.getDescricao());
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
		
		ListaTarefa listaTarefa = new ListaTarefa(1L, "Teste", Instant.now(),new Usuario(1L, "João", 30, "joão@gmail.com"));
		
		Tarefa lista = new Tarefa (1L, "Provas","Estudar para prova",false, listaTarefa);
		
		TarefaDTO tarefaDTO = new TarefaDTO(lista);
		
		assertEquals(tarefaDTO.getId(), lista.getId());
		assertEquals(tarefaDTO.getNome(), lista.getNome());
		assertEquals(tarefaDTO.getDescricao(), lista.getDescricao());
		assertEquals(tarefaDTO.isConcluida(), lista.isConcluida());
		assertEquals(tarefaDTO.getListaTarefaDTO().getTitulo(), lista.getListaTarefa().getTitulo());
	}
	
	@Test
	public void ConstructorWithArguments() {
		
		ListaTarefaDTO listaTarefaDTO = new ListaTarefaDTO();
		
		TarefaDTO tarefaDTO = new TarefaDTO(1L, "Mercado", "Fazer as compras", false, listaTarefaDTO );
		
		assertNotNull(tarefaDTO);
		assertTrue(tarefaDTO.getId() == 1L);
	}
	
	@Test
	public void testSetters() {
		
		ListaTarefaDTO listaTarefaDTO = new ListaTarefaDTO();
		
		TarefaDTO tarefaDTO = new TarefaDTO();
		tarefaDTO.setId(1L);
		tarefaDTO.setNome("Mercado");
		tarefaDTO.setDescricao("Fazer as compras");
		tarefaDTO.setConcluida(false);
		tarefaDTO.setListaTarefaDTO(listaTarefaDTO);
		
		assertNotNull(tarefaDTO);
		assertTrue(tarefaDTO.getId() == 1L);
	}
}
