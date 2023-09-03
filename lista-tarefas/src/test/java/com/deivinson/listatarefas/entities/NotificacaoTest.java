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
		
		notificacao.setId(1);
		assertEquals(1, notificacao.getId());
	}
	
	@Test
	public void testSetAndGetMensagem() {
		
		String esperado = notificacao.setMensagem("Falta concluir");
		assertEquals(esperado, notificacao.getMensagem());
	}
	
	@Test
	public void testSetAndGetDataHora() {
		
		Instant instanteEsperado = Instant.now();
		
		notificacao.setDataHora(instanteEsperado);
		
		assertEquals(instanteEsperado, notificacao.getMensagem());
	}
	
	@Test
	public void testNotificacaoExibida() {
		
		boolean notificacaoExibida = notificacao.setConcluida(true);
		
		assertTrue(notificacaoExibida);
	}
	
	@Test
	public void testSetAndIsExibida() {
		
		notificacao.setExibida(false);
		
		boolean naoFoiExibida = notificacao.isExibida();
		
		assertFalse(naoFoiExibida);
	}
	
}
