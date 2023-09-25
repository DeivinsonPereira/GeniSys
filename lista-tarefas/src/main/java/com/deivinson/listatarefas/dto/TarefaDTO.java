package com.deivinson.listatarefas.dto;

import com.deivinson.listatarefas.entities.Tarefa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TarefaDTO {

	private Long id;
	private String nome;
	private String descricao;
	private boolean concluida;
	
	private ListaTarefaDTO listaTarefaDTO;


	public TarefaDTO(Long id, String nome, String descricao, boolean concluida, ListaTarefaDTO listaTarefa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.concluida = concluida;
		this.listaTarefaDTO = listaTarefa;
	}
	
	public TarefaDTO(Tarefa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.concluida = entity.isConcluida();
		this.listaTarefaDTO = new ListaTarefaDTO(entity.getListaTarefa());
	}

}