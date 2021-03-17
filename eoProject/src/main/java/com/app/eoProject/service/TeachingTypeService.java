package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Student;
import com.app.eoProject.model.TeachingType;
import com.app.eoProject.repository.StudentRepository;
import com.app.eoProject.repository.TeachingTypeRepository;

@Service
public class TeachingTypeService implements TeachingTypeServiceInterface{

	@Autowired
	TeachingTypeRepository repo;
	
	@Override
	public TeachingType findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<TeachingType> findAll() {
		return repo.findAll();
	}

	@Override
	public TeachingType save(TeachingType param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in TeachingType service...");
		repo.deleteById(id);
	}
}
