package com.app.eoProject.service;

import org.springframework.stereotype.Service;

import com.app.eoProject.model.CourseSpecification;
import com.app.eoProject.repository.CourseSpecificationRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseSpecificationService implements CourseSpecificationServiceInterface{

	@Autowired
	CourseSpecificationRepository repo;
	
	@Override
	public CourseSpecification findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<CourseSpecification> findAll() {
		return repo.findAll();
	}

	@Override
	public CourseSpecification save(CourseSpecification param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in CourseSpecification service...");
		repo.deleteById(id);
	}
	
}
