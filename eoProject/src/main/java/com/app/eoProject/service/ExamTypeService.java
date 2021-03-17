package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.ExamType;
import com.app.eoProject.model.Student;
import com.app.eoProject.repository.ExamTypeRepository;
import com.app.eoProject.repository.StudentRepository;

@Service
public class ExamTypeService implements ExamTypeServiceInterface {

	@Autowired
	ExamTypeRepository repo;
	
	@Override
	public ExamType findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<ExamType> findAll() {
		return repo.findAll();
	}

	@Override
	public ExamType save(ExamType param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in ExamType service...");
		repo.deleteById(id);
	}
}
