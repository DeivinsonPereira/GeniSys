package com.deivinson.listatarefas.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.deivinson.listatarefas.dto.TaskListDTO;
import com.deivinson.listatarefas.entities.TaskList;
import com.deivinson.listatarefas.entities.Usuario;
import com.deivinson.listatarefas.repositories.ListaTarefaRepository;
import com.deivinson.listatarefas.repositories.UsuarioRepository;

public class ListaTarefaService {

	@Autowired
	private ListaTarefaRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public TaskListDTO insertTask(TaskListDTO dto) {
		
		TaskList taskList = new TaskList();
		taskList.setTitulo(dto.getTitulo());
		taskList.setVencimento(dto.getVencimento());
		Usuario usuario = usuarioRepository.findById(dto.getId())
	            .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
		taskList.setUsuario(usuario);

		repository.save(taskList);
		
		return new TaskListDTO(taskList);
	}
	
	
}
