package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
