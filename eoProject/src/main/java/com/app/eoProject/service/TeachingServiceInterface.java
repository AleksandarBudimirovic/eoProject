package com.app.eoProject.service;

import java.util.List;

import com.app.eoProject.model.Teaching;

public interface TeachingServiceInterface {
	
	Teaching findOne(Long id);
	
	List<Teaching> findAll();
	
	Teaching save(Teaching teaching);
	
	void remove(Long id);

}
