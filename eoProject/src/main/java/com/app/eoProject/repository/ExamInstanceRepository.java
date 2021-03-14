package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.ExamInstance;

public interface ExamInstanceRepository extends JpaRepository<ExamInstance, Long> {

}
