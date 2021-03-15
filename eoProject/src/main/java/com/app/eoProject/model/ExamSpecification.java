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
@Table(name = "examSpecification")
public class ExamSpecification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examSpecification_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "examScoreMax", unique = false, nullable = false)
	private Double examScoreMax;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examInstance", referencedColumnName = "examInstance_id")
	private ExamInstance examInstance;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student", referencedColumnName = "student_id")
	private Student student;

	public ExamSpecification(Long id, Double examScoreMax, Date date, ExamInstance examInstance, Student student) {
		super();
		this.id = id;
		this.examScoreMax = examScoreMax;
		this.date = date;
		this.examInstance = examInstance;
		this.student = student;
	}

	public ExamSpecification() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getExamScoreMax() {
		return examScoreMax;
	}

	public void setExamScoreMax(Double examScoreMax) {
		this.examScoreMax = examScoreMax;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ExamInstance getExamInstance() {
		return examInstance;
	}

	public void setExamInstance(ExamInstance examInstance) {
		this.examInstance = examInstance;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	
}
