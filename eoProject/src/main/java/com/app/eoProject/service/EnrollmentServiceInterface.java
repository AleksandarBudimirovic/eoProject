package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Enrollment;



public interface EnrollmentServiceInterface {
	
	Enrollment findOne(Long id);
	
	List<Enrollment> findAll();
	
	Enrollment save(Enrollment enrollment);
	
	void remove(Long id);
	

}
