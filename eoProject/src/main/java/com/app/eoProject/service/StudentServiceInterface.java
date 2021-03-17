package com.app.eoProject.service;

import java.util.List;
import com.app.eoProject.model.Student;


public interface StudentServiceInterface {

	Student findOne(Long id);
	
	List<Student> findAll();
	
	Student save(Student student);
	
	void remove(Long id);
	
}
