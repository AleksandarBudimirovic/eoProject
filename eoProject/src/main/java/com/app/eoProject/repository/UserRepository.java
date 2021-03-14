package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.eoProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	
}
