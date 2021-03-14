package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
