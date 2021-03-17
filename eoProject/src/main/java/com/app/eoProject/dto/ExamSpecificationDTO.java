package com.app.eoProject.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.model.ExamSpecification;
import com.app.eoProject.model.Student;

public class ExamSpecificationDTO implements Serializable{

	private Long id;
	private double examScoreMax;
	private Date date;
	private ExamInstanceDTO examInstance;
	private StudentDTO student;
	
	public ExamSpecificationDTO(Long id, double examScoreMax, Date date, ExamInstanceDTO examInstance,
			StudentDTO student) {
		super();
		this.id = id;
		this.examScoreMax = examScoreMax;
		this.date = date;
		this.examInstance = examInstance;
		this.student = student;
	}
	
	public ExamSpecificationDTO() {
		super();
	}
	
	public ExamSpecificationDTO(ExamSpecification examSpec) {
		this(examSpec.getId(), examSpec.getExamScoreMax(), examSpec.getDate(), new ExamInstanceDTO(examSpec.getExamInstance()), new StudentDTO(examSpec.getStudent()));
	}
	
	public Long getId() {
		return id;
	}

	public double getExamScoreMax() {
		return examScoreMax;
	}
	public void setExamScoreMax(double examScoreMax) {
		this.examScoreMax = examScoreMax;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ExamInstanceDTO getExamInstance() {
		return examInstance;
	}
	public void setExamInstance(ExamInstanceDTO examInstance) {
		this.examInstance = examInstance;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	
	
}
