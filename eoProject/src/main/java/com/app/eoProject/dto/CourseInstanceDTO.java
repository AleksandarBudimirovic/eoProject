package com.app.eoProject.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.app.eoProject.model.CourseInstance;


public class CourseInstanceDTO implements Serializable{
	

	private Long id;
	private Date startDate;
	private Date endDate;
	private ArrayList<CourseSpecificationDTO> courseSpecification = new ArrayList<CourseSpecificationDTO>();
	private ExamSpecificationDTO examSpecification;
	private EnrollmentDTO enrollment;
	private TeachingDTO teaching;
	
	public CourseInstanceDTO(Long id, Date startDate, Date endDate, ArrayList<CourseSpecificationDTO> courseSpecification,
			ExamSpecificationDTO examSpecification, EnrollmentDTO enrollment, TeachingDTO teaching) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseSpecification = courseSpecification;
		this.examSpecification = examSpecification;
		this.enrollment = enrollment;
		this.teaching = teaching;
	}
	
	public CourseInstanceDTO(CourseInstance courseInstance) {
		this(courseInstance.getId(), courseInstance.getStartDate(), courseInstance.getEndDate(), new ArrayList<CourseSpecificationDTO>(), new ExamSpecificationDTO(courseInstance.getExamSpecification()), 
				new EnrollmentDTO(courseInstance.getEnrollment()), new TeachingDTO(courseInstance.getTeaching()));
	}
	
	public CourseInstanceDTO() {
		super();
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
	public ArrayList<CourseSpecificationDTO> getCourseSpecification() {
		return courseSpecification;
	}
	public void setCourseSpecification(ArrayList<CourseSpecificationDTO> courseSpecification) {
		this.courseSpecification = courseSpecification;
	}
	public ExamSpecificationDTO getExamSpecification() {
		return examSpecification;
	}
	public void setExamSpecification(ExamSpecificationDTO examSpecification) {
		this.examSpecification = examSpecification;
	}
	public EnrollmentDTO getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(EnrollmentDTO enrollment) {
		this.enrollment = enrollment;
	}
	public TeachingDTO getTeaching() {
		return teaching;
	}
	public void setTeaching(TeachingDTO teaching) {
		this.teaching = teaching;
	}
	public Long getId() {
		return id;
	}
	
	

}
