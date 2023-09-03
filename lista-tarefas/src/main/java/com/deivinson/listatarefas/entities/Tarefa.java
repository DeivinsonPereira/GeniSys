package com.deivinson.listatarefas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataInclusao;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant vencimento;
	private boolean concluida;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "tarefa")
	private Set<Notificacao> notificacoes = new HashSet<>();
	
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Set<Notificacao> getNotificacoes() {
		return notificacoes;
	}
	
	@PrePersist
	public void prePersist() {
		dataInclusao = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		vencimento = Instant.now();
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
