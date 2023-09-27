package com.deivinson.genisys.entities;

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
@Table(name = "tb_task_list")
public class TaskList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant inclusionDate;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant expirationDate;
	private boolean completed;
	
	@OneToMany(mappedBy = "taskList")
	private Set<Notification> notifications = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Task> tasks = new ArrayList<>();
	
	public TaskList(Long id, String title, Instant expirationDate, User user) {
		this.id = id;
		this.title = title;
		this.inclusionDate = Instant.now();
		this.expirationDate = expirationDate;
		this.completed = false;
		this.user = user;
	}
	
	@SuppressWarnings("unused")
	private void setMessage(List<Notification> notifications) {}
	
	@SuppressWarnings("unused")
	private void setTaskList(List<Task> tasks) {}
	
	@SuppressWarnings("unused")
	private void setInclusionDate(Instant inclusionDate) {}

}
