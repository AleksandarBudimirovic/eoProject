package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Teaching;
import com.app.eoProject.repository.TeachingRepository;

@Service
public class TeachingService implements TeachingServiceInterface {
	
	@Autowired
	TeachingRepository repo;
	
	@Override
	public Teaching findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Teaching> findAll() {
		return repo.findAll();
	}

	@Override
	public Teaching save(Teaching param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Teaching service...");
		repo.deleteById(id);
	}

}
