package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
