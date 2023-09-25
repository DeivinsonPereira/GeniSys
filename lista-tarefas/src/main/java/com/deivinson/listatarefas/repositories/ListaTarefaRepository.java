package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.TaskList;

public interface ListaTarefaRepository extends JpaRepository<TaskList, Long>{

}
