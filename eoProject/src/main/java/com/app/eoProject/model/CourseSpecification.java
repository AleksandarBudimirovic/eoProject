package com.app.eoProject.model;

import java.io.Serializable;
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
@Table(name = "course_specification")
public class CourseSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_specification_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "title", unique = false, nullable = false)
	private String title;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	@Column(name = "ECTS", unique = false, nullable = false)
	private String ECTS;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_instance", referencedColumnName = "course_instance_id", nullable = true)
	private CourseInstance courseInstance;
	


	public CourseSpecification(Long id, String title, String code, String eCTS, CourseInstance courseInstance) {
		super();
		this.id = id;
		this.title = title;
		this.code = code;
		ECTS = eCTS;
		this.courseInstance = courseInstance;
	}

	public CourseSpecification() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public CourseInstance getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstance courseInstance) {
		this.courseInstance = courseInstance;
	}

	
	
	

}
