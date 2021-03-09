package com.app.eoProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "courseSpecification")
public class CourseSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseSpecification_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "title", unique = false, nullable = false)
	private String title;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	@Column(name = "ECTS", unique = false, nullable = false)
	private String ECTS;

	public CourseSpecification() {
		super();
	}

	public CourseSpecification(Long id, String title, String code, String eCTS) {
		super();
		this.id = id;
		this.title = title;
		this.code = code;
		ECTS = eCTS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getECTS() {
		return ECTS;
	}

	public void setECTS(String eCTS) {
		ECTS = eCTS;
	}
	
	

}
