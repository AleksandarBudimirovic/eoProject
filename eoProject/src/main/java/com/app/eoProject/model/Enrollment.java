package com.app.eoProject.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment")
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Student student;
	
	
	@Column(name = "startDate", unique = false, nullable = false)
	private Date startDate;
	
	@Column(name = "endDate", unique = false, nullable = false)
	private Date endDate;
	

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "enrollment")
	private Set<CourseInstance> courseInstance = new HashSet<CourseInstance>();


	public Enrollment(Long id, Student student, Date startDate, Date endDate, Set<CourseInstance> courseInstance) {
		super();
		this.id = id;
		this.student = student;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseInstance = courseInstance;
	}


	public Enrollment() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Set<CourseInstance> getCourseInstance() {
		return courseInstance;
	}


	public void setCourseInstance(Set<CourseInstance> courseInstance) {
		this.courseInstance = courseInstance;
	}
		
	
	
}
