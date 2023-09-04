package com.deivinson.listatarefas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deivinson.listatarefas.entities.ListaTarefa;
import com.deivinson.listatarefas.entities.ListaTarefaDTO;
import com.deivinson.listatarefas.entities.Usuario;

public class ListaTarefaDTOTest {

	private ListaTarefaDTO listaTarefaDTO;
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		
		ListaTarefaDTO = new ListaTarefaDTO();
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
		
		Instant now = Instant.now();
		Instant any = any();
		
		ListaTarefa lista = new ListaTarefa (1L, "Provas", now, any,false, new Usuario(usuario.getId(), usuario.getNome(),usuario.getIdade(),usuario.getEmail()));
		
		ListaTarefaDTO listaTarefaDTO = new ListaTarefaDTO(lista);
		
		assertEquals(listaTarefaDTO.getId(), lista.getId());
		assertEquals(listaTarefaDTO.getTitulo(), lista.getTitulo());
		assertEquals(listaTarefaDTO.getDataInclusao(), lista.getDataInclusao());
		assertEquals(listaTarefaDTO.isConcluida(), lista.isConcluida());
		assertEquals(listaTarefaDTO.getUsuario().getId(), lista.getUsuario().getId());
		assertEquals(listaTarefaDTO.getUsuario().getNome(), lista.getUsuario().getNome());
		
	}
	
}
