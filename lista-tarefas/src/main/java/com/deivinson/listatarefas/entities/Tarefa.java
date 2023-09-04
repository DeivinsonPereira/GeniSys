package com.deivinson.listatarefas.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	private boolean concluida;
	
	@ManyToOne
	@JoinColumn(name = "lista_tarefa_id")
	private ListaTarefa listaTarefa;
	
	public Tarefa() {
	}
	
	public Tarefa(Long id, String nome, String descricao, boolean concluida, ListaTarefa listaTarefa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.concluida = concluida;
		this.listaTarefa = listaTarefa;
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

	public ListaTarefa getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(ListaTarefa listaTarefa) {
		this.listaTarefa = listaTarefa;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}
	
}
