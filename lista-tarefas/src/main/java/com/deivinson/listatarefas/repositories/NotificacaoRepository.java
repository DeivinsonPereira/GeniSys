package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{

}
