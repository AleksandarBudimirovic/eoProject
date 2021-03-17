package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Payment;


public interface PaymentServiceInterface {
	
	Payment findOne(Long id);
	
	List<Payment> findAll();
	
	Payment save(Payment payment);
	
	void remove(Long id);

}
