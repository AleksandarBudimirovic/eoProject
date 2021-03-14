package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.TeachingType;


public interface TeachingTypeRepository extends JpaRepository<TeachingType, Long> {
	
	TeachingType findByName (String name);

}
