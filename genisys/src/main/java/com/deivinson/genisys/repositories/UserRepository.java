package com.deivinson.genisys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.genisys.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
