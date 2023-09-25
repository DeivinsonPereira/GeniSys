package com.deivinson.listatarefas.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotificationTest {
	
	private Notification notification;
	
	@BeforeEach
	public void setUp() {
		
		notification = new Notification();
	}
	
	@Test
	public void testSetAndGetId() {
		
		notification.setId(1L);
		assertEquals(1L, notification.getId());
	}
	
	@Test
	public void testSetAndGetMessage() {
		
		notification.setMessage("Yet to be completed");
		assertEquals("Yet to be completed", notification.getMessage());
	}
	
	@Test
	public void testSetAndGetDateTime() {
		
		Instant expectedInstant = Instant.now();
		
		notification.setDateTime(expectedInstant);
		
		assertEquals(expectedInstant, notification.getDateTime());
	}
	
	@Test
	public void testNotificacaoDisplayed() {
		
		notification.setDisplayed(true);
		
		assertTrue(notification.isDisplayed());
	}
	
	@Test
	public void testSetAndIsDisplayed() {
		
		notification.setDisplayed(false);
		
		assertFalse(notification.isDisplayed());
	}
	
}
