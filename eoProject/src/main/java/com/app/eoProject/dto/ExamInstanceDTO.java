package com.app.eoProject.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.model.ExamSpecification;
import com.app.eoProject.model.Student;
import com.app.eoProject.model.Teacher;

public class ExamInstanceDTO implements Serializable {
	
	private Long id;
	private Date startDate;
	private Date endDate;
	private StudentDTO student;
	private Double pointsScored;
	private TeacherDTO teacher;
	private ExamSpecificationDTO examSpecification;
	
	
	public ExamInstanceDTO(Long id, Date startDate, Date endDate, StudentDTO student, Double pointsScored,
			TeacherDTO teacher, ExamSpecificationDTO examSpecification) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
		this.pointsScored = pointsScored;
		this.teacher = teacher;
		this.examSpecification = examSpecification;
	}
	
	
	public ExamInstanceDTO() {
		super();
	}
	
	
	public ExamInstanceDTO(ExamInstance examInstance) {
		this(examInstance.getId(), examInstance.getStartDate(), examInstance.getEndDate(),
				new StudentDTO(examInstance.getStudent()), examInstance.getPointsScored(),
				new TeacherDTO(examInstance.getTeacher()), new ExamSpecificationDTO(examInstance.getExamSpecification()));
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
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public Double getPointsScored() {
		return pointsScored;
	}
	public void setPointsScored(Double pointsScored) {
		this.pointsScored = pointsScored;
	}
	public TeacherDTO getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}
	public ExamSpecificationDTO getExamSpecification() {
		return examSpecification;
	}
	public void setExamSpecification(ExamSpecificationDTO examSpecification) {
		this.examSpecification = examSpecification;
	}
	public Long getId() {
		return id;
	}
	
	
	
	

}
