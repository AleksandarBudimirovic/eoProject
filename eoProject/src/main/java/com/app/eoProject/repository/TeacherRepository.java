package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findByName (String name);
	
	Teacher findByLastname (String lastname);

}
