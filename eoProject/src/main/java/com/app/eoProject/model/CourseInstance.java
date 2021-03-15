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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "courseSpecification")
	private Set<CourseSpecification> courseSpecification = new HashSet<CourseSpecification>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examSpecification", referencedColumnName = "examSpecification_id")
	private ExamSpecification examSpecification;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enrollment", referencedColumnName = "enrollment_id")
	private Enrollment enrollment;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teaching", referencedColumnName = "teaching_id")
	private Teaching teaching;

	public CourseInstance(Long id, Date startDate, Date endDate, Set<CourseSpecification> courseSpecification,
			ExamSpecification examSpecification, Enrollment enrollment, Teaching teaching) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseSpecification = courseSpecification;
		this.examSpecification = examSpecification;
		this.enrollment = enrollment;
		this.teaching = teaching;
	}

	public CourseInstance() {
		super();
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

	public Set<CourseSpecification> getCourseSpecification() {
		return courseSpecification;
	}

	public void setCourseSpecification(Set<CourseSpecification> courseSpecification) {
		this.courseSpecification = courseSpecification;
	}

	public ExamSpecification getExamSpecification() {
		return examSpecification;
	}

	public void setExamSpecification(ExamSpecification examSpecification) {
		this.examSpecification = examSpecification;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Teaching getTeaching() {
		return teaching;
	}

	public void setTeaching(Teaching teaching) {
		this.teaching = teaching;
	}

	

	
	

	
	
	
	
	
}
