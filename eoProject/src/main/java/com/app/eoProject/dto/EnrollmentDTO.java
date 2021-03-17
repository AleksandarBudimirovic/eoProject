package com.app.eoProject.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;



import com.app.eoProject.model.Enrollment;


public class EnrollmentDTO implements Serializable {
	
	private Long id;
	private StudentDTO student;
	private Date startDate;
	private Date endDate;
	private ArrayList<CourseInstanceDTO> courseInstanceDTO = new ArrayList<CourseInstanceDTO>();
	
	
	public EnrollmentDTO(Long id, StudentDTO student, Date startDate, Date endDate,
			ArrayList<CourseInstanceDTO> courseInstanceDTO) {
		super();
		this.id = id;
		this.student = student;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseInstanceDTO = courseInstanceDTO;
	}
	
	
	public EnrollmentDTO() {
		super();
	}
	
	
	public EnrollmentDTO(Enrollment enrollment) {
		this(enrollment.getId(), new StudentDTO(enrollment.getStudent()), enrollment.getStartDate(),
				enrollment.getEndDate(), new ArrayList<CourseInstanceDTO>() );
	}
	
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
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
	public ArrayList<CourseInstanceDTO> getCourseInstanceDTO() {
		return courseInstanceDTO;
	}
	public void setCourseInstanceDTO(ArrayList<CourseInstanceDTO> courseInstanceDTO) {
		this.courseInstanceDTO = courseInstanceDTO;
	}
	public Long getId() {
		return id;
	}
	
	

}
