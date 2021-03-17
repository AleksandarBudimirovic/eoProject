package com.app.eoProject.service;

import java.util.List;
import com.app.eoProject.model.ExamSpecification;


public interface ExamSpecificationServiceInterface {

	ExamSpecification findOne(Long id);
	
	List<ExamSpecification> findAll();
	
	ExamSpecification save(ExamSpecification account);
	
	void remove(Long id);
	
}
