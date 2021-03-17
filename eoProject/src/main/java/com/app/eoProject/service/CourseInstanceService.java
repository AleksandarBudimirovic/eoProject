package com.app.eoProject.service;

import org.springframework.stereotype.Service;

import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.Student;
import com.app.eoProject.repository.CourseInstanceRepository;
import com.app.eoProject.repository.StudentRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourseInstanceService implements CourseInstanceServiceInterface{

	@Autowired
	CourseInstanceRepository repo;
	
	@Override
	public CourseInstance findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<CourseInstance> findAll() {
		return repo.findAll();
	}

	@Override
	public CourseInstance save(CourseInstance param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in CourseInstance service...");
		repo.deleteById(id);
	}
	
}
