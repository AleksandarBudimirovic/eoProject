package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Payment;
import com.app.eoProject.repository.PaymentRepository;


@Service
public class PaymentService implements PaymentServiceInterface {

	@Autowired
	PaymentRepository repo;
	
	@Override
	public Payment findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Payment> findAll() {
		return repo.findAll();
	}

	@Override
	public Payment save(Payment param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Payment service...");
		repo.deleteById(id);
	}
	
}
