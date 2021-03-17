package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.ExamInstance;


public interface ExamInstanceServiceInterface {
	
	ExamInstance findOne(Long id);
	
	List<ExamInstance> findAll();
	
	ExamInstance save(ExamInstance examInstance);
	
	void remove(Long id);

}
