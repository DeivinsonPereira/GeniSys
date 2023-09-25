package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.TaskList;
import com.deivinson.listatarefas.entities.Task;
import com.deivinson.listatarefas.entities.User;

public class TaskDTOTest {

	private TaskDTO tarefaDTO;
	
	@BeforeEach
	public void setUp() {
		
		tarefaDTO = new TaskDTO();
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
		
		TaskList listaTarefa = new TaskList(1L, "Teste", Instant.now(),new User(1L, "João", 30, "joão@gmail.com"));
		
		Task lista = new Task (1L, "Provas","Estudar para prova",false, listaTarefa);
		
		TaskDTO tarefaDTO = new TaskDTO(lista);
		
		assertEquals(tarefaDTO.getId(), lista.getId());
		assertEquals(tarefaDTO.getNome(), lista.getNome());
		assertEquals(tarefaDTO.getDescricao(), lista.getDescricao());
		assertEquals(tarefaDTO.isConcluida(), lista.isConcluida());
		assertEquals(tarefaDTO.getListaTarefaDTO().getTitulo(), lista.getListaTarefa().getTitulo());
	}
	
	@Test
	public void ConstructorWithArguments() {
		
		TaskListDTO listaTarefaDTO = new TaskListDTO();
		
		TaskDTO tarefaDTO = new TaskDTO(1L, "Mercado", "Fazer as compras", false, listaTarefaDTO );
		
		assertNotNull(tarefaDTO);
		assertTrue(tarefaDTO.getId() == 1L);
	}
	
	@Test
	public void testSetters() {
		
		TaskListDTO listaTarefaDTO = new TaskListDTO();
		
		TaskDTO tarefaDTO = new TaskDTO();
		tarefaDTO.setId(1L);
		tarefaDTO.setNome("Mercado");
		tarefaDTO.setDescricao("Fazer as compras");
		tarefaDTO.setConcluida(false);
		tarefaDTO.setListaTarefaDTO(listaTarefaDTO);
		
		assertNotNull(tarefaDTO);
		assertTrue(tarefaDTO.getId() == 1L);
	}
}
