package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Teacher;

public interface TeacherServiceInterface {
	
	Teacher findOne(Long id);
	
	List<Teacher> findAll();
	
	Teacher save(Teacher teacher);
	
	void remove(Long id);

}
