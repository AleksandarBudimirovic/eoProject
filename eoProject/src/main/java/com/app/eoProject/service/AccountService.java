package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Account;
import com.app.eoProject.model.Student;
import com.app.eoProject.repository.AccountRepository;
import com.app.eoProject.repository.StudentRepository;

@Service
public class AccountService implements AccountServiceInterface{ 

	@Autowired
	AccountRepository repo;
	
	@Override
	public Account findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Account> findAll() {
		return repo.findAll();
	}

	@Override
	public Account save(Account param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Account service...");
		repo.deleteById(id);
	}
}
