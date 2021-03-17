package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.repository.ExamInstanceRepository;


@Service
public class ExamInstanceService implements ExamInstanceServiceInterface {

	@Autowired
	ExamInstanceRepository repo;
	
	@Override
	public ExamInstance findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<ExamInstance> findAll() {
		return repo.findAll();
	}

	@Override
	public ExamInstance save(ExamInstance param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in ExamInstance service...");
		repo.deleteById(id);
	}
	
}
