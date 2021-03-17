package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Document;


public interface DocumentServiceInterface {
	
	Document findOne(Long id);
	
	List<Document> findAll();
	
	Document save(Document document);
	
	void remove(Long id);

}
