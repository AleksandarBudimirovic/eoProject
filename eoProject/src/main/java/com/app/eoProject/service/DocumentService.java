package com.app.eoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eoProject.model.Document;
import com.app.eoProject.repository.DocumentRepository;


@Service
public class DocumentService implements DocumentServiceInterface {

	@Autowired
	DocumentRepository repo;
	
	@Override
	public Document findOne(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Document> findAll() {
		return repo.findAll();
	}

	@Override
	public Document save(Document param) {
		return repo.save(param);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Document service...");
		repo.deleteById(id);
	}
	
}
