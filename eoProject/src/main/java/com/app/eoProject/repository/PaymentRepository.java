package com.app.eoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findAll();

}
