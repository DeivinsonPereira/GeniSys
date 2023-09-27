package com.deivinson.genisys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.genisys.entities.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, Long>{

}
