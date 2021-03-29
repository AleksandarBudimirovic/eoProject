package com.app.eoProject.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.app.eoProject.dto.AccountDTO;
import com.app.eoProject.dto.PaymentDTO;
import com.app.eoProject.model.Account;
import com.app.eoProject.model.Payment;
import com.app.eoProject.service.AccountServiceInterface;
import com.app.eoProject.service.PaymentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;


@RestController
@RequestMapping(value = "api/accounts")
public class AccountController {
		
		@Autowired
		private StudentServiceInterface studentService;
		@Autowired
		private AccountServiceInterface accountService;
		@Autowired
		private PaymentServiceInterface paymentService;
		
		
		@GetMapping
		public ResponseEntity<List<AccountDTO>> getAccount(){
			
			List<Account> accounts = accountService.findAll();		
			
			List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
			
			for(Account a: accounts) {
				
				AccountDTO objDTO = new AccountDTO(a);
				
				accountsDTO.add(objDTO);
			}
			
			return new ResponseEntity<List<AccountDTO>>(accountsDTO, HttpStatus.OK);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<AccountDTO> getAccount(@PathVariable("id") Long id) {
			
			Account account = accountService.findOne(id);
			
			if(account == null){
				return new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.OK);
		}
		
		@PostMapping(consumes="application/json")
		public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
			Account account = new Account();
			
			account.setName(accountDTO.getName());
			account.setAmount(accountDTO.getAmount());
			account.setDate(accountDTO.getDate());
			account.setStudent(studentService.findOne(accountDTO.getStudent().getId()));
			

			Set<Payment> payments = new HashSet<Payment>();
			for(PaymentDTO pDTO : accountDTO.getPayments()) {
				for(Payment pi : paymentService.findAll()) {
					if(pDTO.getId() == pi.getId()) {
						payments.add(pi);
					}
				}
				
				
			}
			account.setPayment(payments);
			
			
			

				
			account = accountService.save(account);
			return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.CREATED);	
		}
		
		@PutMapping(value="/{id}", consumes="application/json")
		public ResponseEntity<AccountDTO> editAccount(@RequestBody AccountDTO accountDTO, @PathVariable("id") Long id) {
			
			Account account = accountService.findOne(id); 
			
			if (account == null) {
				return new ResponseEntity<AccountDTO>(HttpStatus.BAD_REQUEST);
			}
			
			account.setName(accountDTO.getName());
			account.setAmount(accountDTO.getAmount());
			account.setDate(accountDTO.getDate());
			account.setStudent(studentService.findOne(accountDTO.getStudent().getId()));
			

			Set<Payment> payments = new HashSet<Payment>();
			for(PaymentDTO pDTO : accountDTO.getPayments()) {
				for(Payment pi : paymentService.findAll()) {
					if(pDTO.getId() == pi.getId()) {
						payments.add(pi);
					}
				}
				
				
			}
			account.setPayment(payments);
			
			
			

				
			account = accountService.save(account);
			return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.OK);		
		
		}
		
		@DeleteMapping(value="/{id}")
		public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
			Account account = accountService.findOne(id);
			if (account != null){
				System.out.println("account nije null");
				
				System.out.println("Id je: " + id);
				
				accountService.remove(id);
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
