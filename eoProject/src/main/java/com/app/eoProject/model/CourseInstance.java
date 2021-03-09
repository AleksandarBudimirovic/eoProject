package com.app.eoProject.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courseInstance")
public class CourseInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseInstance_id", unique = true, nullable = false)
	private Long id;
	
	private Date startDate;
	
	private Date endDate;
	
	
	
}
