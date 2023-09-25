package com.deivinson.listatarefas.dto;

import com.deivinson.listatarefas.entities.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {

	private Long id;
	private String nome;
	private String descricao;
	private boolean concluida;
	
	private TaskListDTO listaTarefaDTO;


	public TaskDTO(Long id, String nome, String descricao, boolean concluida, TaskListDTO listaTarefa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.concluida = concluida;
		this.listaTarefaDTO = listaTarefa;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.concluida = entity.isConcluida();
		this.listaTarefaDTO = new TaskListDTO(entity.getListaTarefa());
	}

}