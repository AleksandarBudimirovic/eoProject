package com.app.eoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.CourseSpecification;
import com.app.eoProject.model.Teacher;
import com.app.eoProject.model.Teaching;



public interface TeachingRepository extends JpaRepository<Teaching, Long> {

	List<CourseSpecification> findByTeacher(Teacher profesor);
	//List<CourseInstance> findByTeacher(Teacher profesor);
	
}
