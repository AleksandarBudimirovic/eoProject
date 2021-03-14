package com.app.eoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.eoProject.model.ExamSpecification;
import com.app.eoProject.model.Teacher;

public interface ExamSpecificationRepository extends JpaRepository<ExamSpecification, Long> {
	
	//List<ExamSpecification> findByTeacher(Teacher s);

}
