package com.deivinson.genisys.entities;

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
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private String email;
	
	@OneToMany(mappedBy = "user")
	private Set<Notification> message = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	private List<TaskList> taskLists = new ArrayList<>();
	
	public User(Long id, String name, Integer age, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	@SuppressWarnings("unused")
	private void setMessage(List<Notification> message) {}
	
	@SuppressWarnings("unused")
	private void setTaskList(List<TaskList> taskLists) {}
	
}
