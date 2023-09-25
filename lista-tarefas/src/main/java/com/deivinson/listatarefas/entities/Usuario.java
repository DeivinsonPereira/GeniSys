package com.deivinson.listatarefas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@NoArgsConstructor
@Table(name = "tb_usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	private String email;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Notificacao> mensagem = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<ListaTarefa> listaTarefas = new ArrayList<>();
	
	public Usuario(Long id, String nome, Integer idade, String email) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	@SuppressWarnings("unused")
	private void setMensagem(List<Notificacao> mensagem) {}
	
	@SuppressWarnings("unused")
	private void setListaTarefas(List<ListaTarefa> listaTarefas) {}
	
}
