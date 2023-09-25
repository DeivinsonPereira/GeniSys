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
public class TaskList {
	
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
	private Set<Notification> notificacoes = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private User usuario;
	
	@OneToMany(mappedBy = "listaTarefa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Task> tarefas = new ArrayList<>();
	
	public TaskList(Long id, String titulo, Instant vencimento, User usuario) {
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = Instant.now();
		this.vencimento = vencimento;
		this.concluida = false;
		this.usuario = usuario;
	}
	
	@SuppressWarnings("unused")
	private void setMensagem(List<Notification> notificacoes) {}
	
	@SuppressWarnings("unused")
	private void setListaTarefas(List<Task> tarefas) {}
	
	@SuppressWarnings("unused")
	private void setDataInclusao(Instant dataInclusao) {}

}
