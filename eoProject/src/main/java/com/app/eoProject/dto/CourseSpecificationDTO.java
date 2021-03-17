package com.app.eoProject.dto;

import java.io.Serializable;

import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.CourseSpecification;



public class CourseSpecificationDTO implements Serializable{

	private Long id;
	private String title;
	private String code;
	private String ECTS;
	private CourseInstanceDTO courseInstance;
	
	public CourseSpecificationDTO(Long id, String title, String code, String eCTS, CourseInstanceDTO courseInstance) {
		super();
		this.id = id;
		this.title = title;
		this.code = code;
		ECTS = eCTS;
		this.courseInstance = courseInstance;
	}

	public CourseSpecificationDTO() {
		super();
	}
	
	public CourseSpecificationDTO(CourseSpecification courseSpec) {
		this(courseSpec.getId(), courseSpec.getTitle(), courseSpec.getCode(), courseSpec.getECTS(), new CourseInstanceDTO(courseSpec.getCourseInstance()));
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

	public CourseInstanceDTO getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstanceDTO courseInstance) {
		this.courseInstance = courseInstance;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
}
