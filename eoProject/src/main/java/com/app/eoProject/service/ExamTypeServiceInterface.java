package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.ExamType;

public interface ExamTypeServiceInterface {

	ExamType findOne(Long id);
	
	List<ExamType> findAll();
	
	ExamType save(ExamType examType);
	
	void remove(Long id);
}
