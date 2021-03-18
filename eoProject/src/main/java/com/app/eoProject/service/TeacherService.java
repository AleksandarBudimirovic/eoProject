package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Teacher;
import com.app.eoProject.repository.TeacherRepository;

@Service
public class TeacherService implements TeacherServiceInterface {
	
	@Autowired
	TeacherRepository repo;
	
	@Override
	public Teacher findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Teacher> findAll() {
		return repo.findAll();
	}

	@Override
	public Teacher save(Teacher param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Teacher service...");
		repo.deleteById(id);
	}

}
