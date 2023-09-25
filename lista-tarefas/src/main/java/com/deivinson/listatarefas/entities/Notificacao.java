package com.deivinson.listatarefas.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
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
	
	
}
