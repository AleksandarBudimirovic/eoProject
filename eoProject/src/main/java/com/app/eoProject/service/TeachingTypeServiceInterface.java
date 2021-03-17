package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Student;
import com.app.eoProject.model.TeachingType;

public interface TeachingTypeServiceInterface {

	TeachingType findOne(Long id);
	
	List<TeachingType> findAll();
	
	TeachingType save(TeachingType teachingType);
	
	void remove(Long id);
}
