package com.app.eoProject.dto;

import java.io.Serializable;

import com.app.eoProject.model.Document;
import com.app.eoProject.model.DocumentType;
import com.app.eoProject.model.Student;

public class DocumentDTO implements Serializable {
	
	
	private Long id;
	private DocumentType documentType;
	private StudentDTO student;
	
	public DocumentDTO(Long id, DocumentType documentType, StudentDTO student) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.student = student;
	}

	public DocumentDTO() {
		super();
	}
	
	public DocumentDTO(Document document) {
		this(document.getId(), document.getDocumentType(), new StudentDTO(document.getStudent()));
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}
	
	

}
