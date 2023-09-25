package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
