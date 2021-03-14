package com.app.eoProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teaching")

public class Teaching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teaching_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "courseInstance_id", unique = true, nullable = false)
	private CourseInstance courseInstance;
	
	@Column(name = "teaching_type", unique = false, nullable = false)
	private TeachingType teachingType;
	
	//ne znam da li ovo treba
	//@ManyToOne
	//@JoinColumn(name="teacher", referencedColumnName="teacher_id", nullable=true)
	//private Teacher teacher;

	public Teaching() {
		super();
	}

	public Teaching(Long id, CourseInstance courseInstance, TeachingType teachingType) {
		super();
		this.id = id;
		this.courseInstance = courseInstance;
		this.teachingType = teachingType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseInstance getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstance courseInstance) {
		this.courseInstance = courseInstance;
	}

	public TeachingType getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}

	
	
	
}
