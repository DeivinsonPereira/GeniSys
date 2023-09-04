package com.deivinson.listatarefas.entities;

import java.io.Serializable;
import java.time.Instant;
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
@Table(name = "tb_notificacao")
public class Notificacao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String mensagem;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataHora;
	private boolean exibida;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "lista_tarefa_id")
	private ListaTarefa listaTarefa;
	
	public Notificacao() {
	}

	public Notificacao(Long id, String mensagem, Instant dataHora, boolean exibida, Usuario usuario,
			ListaTarefa listaTarefa) {
		this.id = id;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
		this.exibida = exibida;
		this.usuario = usuario;
		this.listaTarefa = listaTarefa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	public boolean isExibida() {
		return exibida;
	}

	public void setExibida(boolean exibida) {
		this.exibida = exibida;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public ListaTarefa getListaTarefa() {
		return listaTarefa;
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
		Notificacao other = (Notificacao) obj;
		return Objects.equals(id, other.id);
	}
	
}
