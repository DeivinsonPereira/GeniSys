package com.deivinson.listatarefas.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_lista_tarefa")
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
	
	@OneToMany(mappedBy = "listaTarefa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Tarefa> tarefas = new ArrayList<>();
	
	public ListaTarefa(Long id, String titulo, Instant dataInclusao, Instant vencimento, boolean concluida,
			Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = dataInclusao;
		this.vencimento = vencimento;
		this.concluida = concluida;
		this.usuario = usuario;
	}
	
	@SuppressWarnings("unused")
	private void setMensagem(List<Notificacao> notificacoes) {}
	
	@SuppressWarnings("unused")
	private void setListaTarefas(List<Tarefa> tarefas) {}

}
