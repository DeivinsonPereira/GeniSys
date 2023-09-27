package com.deivinson.genisys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.genisys.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
