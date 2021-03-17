package com.app.eoProject.service;

import java.util.List;
import com.app.eoProject.model.CourseInstance;


public interface CourseInstanceServiceInterface {

	CourseInstance findOne(Long id);
	
	List<CourseInstance> findAll();
	
	CourseInstance save(CourseInstance account);
	
	void remove(Long id);
	
}
