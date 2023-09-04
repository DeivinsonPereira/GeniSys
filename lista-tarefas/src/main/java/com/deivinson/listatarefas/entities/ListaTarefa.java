package com.deivinson.listatarefas.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Table;

@Entity
@Table(name = "tb_lista_Tarefa")
public class ListaTarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataInclusao;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant vencimento;
	private boolean concluida;
	
	@OneToMany(mappedBy = "listaTarefa")
	private Set<Notificacao> notificacoes = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "listaTarefa")
	private List<Tarefa> tarefas = new ArrayList<>();
	
	public ListaTarefa() {
	}

	public ListaTarefa(Long id, String titulo, Instant dataInclusao, Instant vencimento, boolean concluida,
			Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = dataInclusao;
		this.vencimento = vencimento;
		this.concluida = concluida;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
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
		ListaTarefa other = (ListaTarefa) obj;
		return Objects.equals(id, other.id);
	}
	
}
