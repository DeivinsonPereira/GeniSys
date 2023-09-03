package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotificacaoTest {
	
	private Notificacao notificacao;
	
	@BeforeEach
	public void setUp() {
		
		notificacao = new Notificacao();
	}
	
	@Test
	public void testSetAndGetId() {
		
		notificacao.setId(1L);
		assertEquals(1L, notificacao.getId());
	}
	
	@Test
	public void testSetAndGetMensagem() {
		
		notificacao.setMensagem("Falta concluir");
		assertEquals("Falta concluir", notificacao.getMensagem());
	}
	
	@Test
	public void testSetAndGetDataHora() {
		
		Instant instanteEsperado = Instant.now();
		
		notificacao.setDataHora(instanteEsperado);
		
		assertEquals(instanteEsperado, notificacao.getDataHora());
	}
	
	@Test
	public void testNotificacaoExibida() {
		
		notificacao.setExibida(true);
		
		assertTrue(notificacao.isExibida());
	}
	
	@Test
	public void testSetAndIsExibida() {
		
		notificacao.setExibida(false);
		
		assertFalse(notificacao.isExibida());
	}
	
}
