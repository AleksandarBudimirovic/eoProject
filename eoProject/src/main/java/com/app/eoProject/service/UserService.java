package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.User;
import com.app.eoProject.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public User findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User save(User param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in User service...");
		repo.deleteById(id);
	}
	
	

}
