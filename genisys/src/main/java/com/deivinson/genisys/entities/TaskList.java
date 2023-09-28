package com.deivinson.genisys.entities;

import java.io.Serializable;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.deivinson.genisys.entities.enums.TaskStatus;

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
public class TaskList implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant inclusionDate;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant expirationDate;
	
	private TaskStatus status;
	
	@OneToMany(mappedBy = "taskList")
	private Set<Notification> notifications = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Task> tasks = new ArrayList<>();
	
	public TaskList(Long id, String title, Instant expirationDate, User user) {
		this.id = id;
		this.title = title;
		this.inclusionDate = Instant.now();
		this.expirationDate = expirationDate;
		this.user = user;
	}
	
	@SuppressWarnings("unused")
	private void setMessage(List<Notification> notifications) {}
	
	@SuppressWarnings("unused")
	private void setTaskList(List<Task> tasks) {}
	
	@SuppressWarnings("unused")
	private void setInclusionDate(Instant inclusionDate) {}
	
	@PrePersist
	public void prePersist() {
		inclusionDate = Instant.now();
	}
	

}
