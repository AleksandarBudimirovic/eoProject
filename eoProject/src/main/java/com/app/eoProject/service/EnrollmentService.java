package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Enrollment;
import com.app.eoProject.repository.EnrollmentRepository;



@Service
public class EnrollmentService {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	public Enrollment findOne(Long id) {
		return enrollmentRepository.findById(id).orElse(null);
	}

	public List<Enrollment> findAll() {
		return enrollmentRepository.findAll();
	}
	
	public Enrollment save(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	public void remove(Long id) {
		enrollmentRepository.deleteById(id);
	}

}
