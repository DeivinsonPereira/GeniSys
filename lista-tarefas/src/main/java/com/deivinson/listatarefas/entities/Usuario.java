package com.deivinson.listatarefas.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	private Long id;
	private String nome;
	private Integer idade;
	private String email;
	
	public Usuario() {
	}

	public Usuario(Long id, String nome, Integer idade, String email) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
