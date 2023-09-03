package com.deivinson.listatarefas.entities;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Tarefa {

	private Long id;
	private String titulo;
	private String descricao;
	private Instant dataInclusao;
	private Instant vencimento;
	private boolean concluida;
	
	public Tarefa() {
	}
	
	public Tarefa(Long id, String titulo, String descricao, Instant dataInclusao, Instant vencimento,
			boolean concluida) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.vencimento = vencimento;
		this.concluida = concluida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Instant dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Instant getVencimento() {
		return vencimento;
	}

	public void setVencimento(Instant vencimento) {
		this.vencimento = vencimento;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
