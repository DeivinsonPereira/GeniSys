package com.deivinson.listatarefas.dto;

import java.time.Instant;

import com.deivinson.listatarefas.entities.ListaTarefa;

public class ListaTarefaDTO {

	private Long id;
	private String titulo;
	private Instant dataInclusao;
	private Instant vencimento;
	private boolean concluida;
	
	private UsuarioDTO usuarioDto;
	
	public ListaTarefaDTO() {
	}

	public ListaTarefaDTO(Long id, String titulo, Instant dataInclusao, Instant vencimento, boolean concluida,
			UsuarioDTO usuarioDto) {
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = dataInclusao;
		this.vencimento = vencimento;
		this.concluida = concluida;
		this.usuarioDto = usuarioDto;
	}
	
	public ListaTarefaDTO(ListaTarefa entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.dataInclusao = entity.getDataInclusao();
		this.vencimento = entity.getVencimento();
		this.concluida = entity.isConcluida();
		this.usuarioDto = new UsuarioDTO(entity.getUsuario());
		
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

	public UsuarioDTO getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDTO usuariodto) {
		this.usuarioDto = usuariodto;
	}

}
