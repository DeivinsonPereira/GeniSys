package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.ListaTarefa;
import com.deivinson.listatarefas.entities.Usuario;

public class ListaTarefaDTOTest {

	private ListaTarefaDTO listaTarefaDTO;
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		
		listaTarefaDTO = new ListaTarefaDTO();
	}
	
	@Test
	public void testSetAndGetId() {
		
		listaTarefaDTO.setId(1L);
		assertEquals(1L, listaTarefaDTO.getId());
	}
	
	@Test
	public void testSetAndGetDataInclusao() {
		
		Instant instanteEsperado = Instant.now();
		
		listaTarefaDTO.setDataInclusao(instanteEsperado);
		
		assertEquals(instanteEsperado, listaTarefaDTO.getDataInclusao());
	}
	
	@Test
	public void testSetAndGetVencimento() {
		
		Instant instanteEsperado = Instant.now();
		
		listaTarefaDTO.setVencimento(instanteEsperado);
		
		assertEquals(instanteEsperado, listaTarefaDTO.getVencimento());
	}
	
	@Test
	public void testEstaConcluida() {
		
		listaTarefaDTO.setConcluida(true);
		
		assertTrue(listaTarefaDTO.isConcluida());
	}
	
	@Test
	public void testSetAndIsConcluida() {
		
		listaTarefaDTO.setConcluida(false);
		
		assertFalse(listaTarefaDTO.isConcluida());
	}
	
		
	@Test
	public void testEntityToDTOConversion() {
		
		
		usuario = new Usuario(1L, "Joelson", 30, "joelson@gmail.com");
		
		ListaTarefa listaTarefa = new ListaTarefa(1L, "Teste", Instant.now(), Instant.now(), false, usuario);
		
		ListaTarefaDTO listatarefaDTO = new ListaTarefaDTO(listaTarefa);
		
		assertEquals(listatarefaDTO.getId(), listaTarefa.getId());
		assertEquals(listatarefaDTO.getTitulo(), listaTarefa.getTitulo());
		assertEquals(listatarefaDTO.getDataInclusao(), listaTarefa.getDataInclusao());
		assertEquals(listatarefaDTO.isConcluida(), listaTarefa.isConcluida());
		assertEquals(listatarefaDTO.getUsuarioDto().getNome(), listaTarefa.getUsuario().getNome());
	}

}
