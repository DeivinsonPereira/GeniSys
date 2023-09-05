package com.deivinson.listatarefas.dto;

import com.deivinson.listatarefas.entities.Tarefa;

public class TarefaDTO {

	private Long id;
	private String nome;
	private String descricao;
	private boolean concluida;
	
	private ListaTarefaDTO listaTarefaDTO;

	public TarefaDTO() {
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public ListaTarefaDTO getListaTarefaDTO() {
		return listaTarefaDTO;
	}

	public void setListaTarefaDTO(ListaTarefaDTO listaTarefaDTO) {
		this.listaTarefaDTO = listaTarefaDTO;
	}

}
