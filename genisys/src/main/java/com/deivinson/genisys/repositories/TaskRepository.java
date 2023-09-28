package com.deivinson.genisys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.genisys.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
