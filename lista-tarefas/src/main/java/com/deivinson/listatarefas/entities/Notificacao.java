package com.deivinson.listatarefas.entities;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notificacao")
public class Notificacao {

	private Long id;
	private String mensagem;
	private Instant dataHora;
	private boolean exibida;
	
	public Notificacao() {
	}

	public Notificacao(Long id, String mensagem, Instant dataHora, boolean exibida) {
		this.id = id;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
		this.exibida = exibida;
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
