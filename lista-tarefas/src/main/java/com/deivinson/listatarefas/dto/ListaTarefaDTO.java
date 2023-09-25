package com.deivinson.listatarefas.dto;

import java.time.Instant;

import com.deivinson.listatarefas.entities.ListaTarefa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListaTarefaDTO {

	private Long id;
	private String titulo;
	private Instant dataInclusao;
	private Instant vencimento;
	private boolean concluida;
	
	private UsuarioDTO usuarioDto;
	
	public ListaTarefaDTO(Long id, String titulo, Instant vencimento, UsuarioDTO usuarioDto) {
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = Instant.now();
		this.vencimento = vencimento;
		this.concluida = false;
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

}
