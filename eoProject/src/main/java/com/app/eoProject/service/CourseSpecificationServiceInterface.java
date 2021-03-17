package com.app.eoProject.service;

import java.util.List;
import com.app.eoProject.model.CourseSpecification;


public interface CourseSpecificationServiceInterface {

	CourseSpecification findOne(Long id);
	
	List<CourseSpecification> findAll();
	
	CourseSpecification save(CourseSpecification account);
	
	void remove(Long id);
	
}
