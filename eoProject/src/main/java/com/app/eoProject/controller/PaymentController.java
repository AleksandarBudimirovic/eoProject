package com.app.eoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.eoProject.dto.PaymentDTO;
import com.app.eoProject.model.Payment;
import com.app.eoProject.service.PaymentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;

@RestController
@RequestMapping(value = "api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentServiceInterface paymentService;
	@Autowired
	private StudentServiceInterface studentService;
	
	
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> getPayments(){
		
		List<Payment> payments = paymentService.findAll();		
		
		List<PaymentDTO> paymentsDTO = new ArrayList<PaymentDTO>();
		
		for(Payment a: payments) {
			
			PaymentDTO objDTO = new PaymentDTO(a);
			
			paymentsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<PaymentDTO>>(paymentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable("id") Long id) {
		
		Payment payment = paymentService.findOne(id);
		
		if(payment == null){
			return new ResponseEntity<PaymentDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		
		payment.setStudent(studentService.findOne(paymentDTO.getStudent().getId()));
		
	
		payment = paymentService.save(payment);
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<PaymentDTO> editPayment(@RequestBody PaymentDTO paymentDTO, @PathVariable("id") Long id) {
		
		Payment payment = paymentService.findOne(id); 
		
		if (payment == null) {
			return new ResponseEntity<PaymentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		
		payment.setStudent(studentService.findOne(paymentDTO.getStudent().getId()));
		
		
		payment = paymentService.save(payment);
		
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id) {
		Payment payment = paymentService.findOne(id);
		if (payment != null){
			System.out.println("Payment is not null");
			
			System.out.println("Id is: " + id);
			
			paymentService.remove(id);
			System.out.println("removed");
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			System.out.println("Not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
