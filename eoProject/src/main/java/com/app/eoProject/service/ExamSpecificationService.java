package com.app.eoProject.service;

import org.springframework.stereotype.Service;
import com.app.eoProject.model.ExamSpecification;
import com.app.eoProject.repository.ExamSpecificationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ExamSpecificationService implements ExamSpecificationServiceInterface{

	@Autowired
	ExamSpecificationRepository repo;
	
	@Override
	public ExamSpecification findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<ExamSpecification> findAll() {
		return repo.findAll();
	}

	@Override
	public ExamSpecification save(ExamSpecification param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in ExamSpecification service...");
		repo.deleteById(id);
	}
	
}
