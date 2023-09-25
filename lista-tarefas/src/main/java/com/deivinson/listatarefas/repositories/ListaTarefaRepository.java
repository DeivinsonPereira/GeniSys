package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.ListaTarefa;

public interface ListaTarefaRepository extends JpaRepository<ListaTarefa, Long>{

}
