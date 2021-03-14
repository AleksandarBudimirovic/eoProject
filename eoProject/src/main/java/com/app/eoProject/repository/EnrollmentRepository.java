package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
