package com.app.eoProject.model;

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
@Table(name = "teaching")

public class Teaching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teaching_id", unique = true, nullable = false)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher", referencedColumnName = "teacher_id")
	private Teacher teacher;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teachingType", referencedColumnName = "teachingType_id")
	private TeachingType teachingType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseInstance", referencedColumnName = "courseInstance_id")
	private CourseInstance courseInstance;
	
	

	public Teaching(Long id, Teacher teacher, TeachingType teachingType, CourseInstance courseInstance) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.teachingType = teachingType;
		this.courseInstance = courseInstance;
	}

	public Teaching() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeachingType getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}

	public CourseInstance getCourseInstance() {
		return courseInstance;
	}

	public void setCourseInstance(CourseInstance courseInstance) {
		this.courseInstance = courseInstance;
	}
	
	
	
	
}
