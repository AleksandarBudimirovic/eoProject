package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
