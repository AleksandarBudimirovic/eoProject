package com.app.eoProject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document")

public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "document_type", unique = false, nullable = false)
	private DocumentType documentType;
	
	//Akina mudrost
	//@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    //private Student student;
	
	@ManyToOne
	@JoinColumn(name="student", referencedColumnName="student_id", nullable=true)
	private Student student;

	public Document() {
		super();
	}

	public Document(Long id, DocumentType documentType, Student student) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
