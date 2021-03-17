package com.app.eoProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Student;
import com.app.eoProject.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	StudentRepository repo;
	
	@Override
	public Student findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public Student save(Student param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Student service...");
		repo.deleteById(id);
	}
	
}
