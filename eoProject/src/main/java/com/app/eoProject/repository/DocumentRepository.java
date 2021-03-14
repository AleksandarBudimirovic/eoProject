package com.app.eoProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eoProject.model.Document;


public interface DocumentRepository extends JpaRepository<Document, Long> {

}
