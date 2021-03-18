package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.User;

public interface UserServiceInterface {
	
	User findOne(Long id);
	
	List<User> findAll();
	
	User save(User user);
	
	void remove(Long id);

}
