package com.app.eoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByCardNumber (String cardNumber);
	
	List<Student> findByLastname (String lastname);

}
