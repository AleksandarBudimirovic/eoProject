package com.app.eoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.Student;
import com.app.eoProject.model.Teacher;
import com.app.eoProject.model.Teaching;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

	List<CourseInstance> findByExamSpecification(Student s);
	List<CourseInstance> findByTeacher(Teacher s);
	//List<CourseInstance> findByTeaching(Teaching s);
	
}
