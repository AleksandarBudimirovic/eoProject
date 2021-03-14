package com.app.eoProject.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courseInstance")
public class CourseInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseInstance_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "startDate", unique = false, nullable = false)
	private Date startDate;
	
	@Column(name = "endDate", unique = false, nullable = false)
	private Date endDate;
	
	//da li nam treba za specexam i speckursa i za teaching i koja anotacija
	
/*	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "courseInstance")
	private Set<CourseSpecification> courseSpecification = new HashSet<CourseSpecification>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "courseInstance")
	private Set<ExamSpecification> examSpecification = new HashSet<ExamSpecification>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "courseInstance")
	private Set<Teaching> teaching = new HashSet<Teaching>();
*/	
	
	

	public CourseInstance() {
		super();
	}
	
	

	public CourseInstance(Long id, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


/*	public Set<CourseSpecification> getCourseSpecification() {
		return courseSpecification;
	}

	public void setCourseSpecification(Set<CourseSpecification> courseSpecification) {
		this.courseSpecification = courseSpecification;
	}

	public Set<ExamSpecification> getExamSpecification() {
		return examSpecification;
	}

	public void setExamSpecification(Set<ExamSpecification> examSpecification) {
		this.examSpecification = examSpecification;
	}

	public Set<Teaching> getTeaching() {
		return teaching;
	}

	public void setTeaching(Set<Teaching> teaching) {
		this.teaching = teaching;
	}
	
*/	
	
	
	
	
}
