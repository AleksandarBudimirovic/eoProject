package com.app.eoProject.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.app.eoProject.dto.CourseInstanceDTO;
import com.app.eoProject.dto.TeacherDTO;
import com.app.eoProject.dto.TeachingTypeDTO;
import com.app.eoProject.model.Teaching;

public class TeachingDTO implements Serializable {
	
	private Long id;
	private TeacherDTO teacher;
	private TeachingTypeDTO teachingType;
	private CourseInstanceDTO courseInstance;
	
	public TeachingDTO(Long id, TeacherDTO teacher, TeachingTypeDTO teachingType, CourseInstanceDTO courseInstance) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.teachingType = teachingType;
		this.courseInstance = courseInstance;
	}

	public TeachingDTO() {
		super();
	}
	
	public TeachingDTO(Teaching teaching) {
        this(teaching.getId(), new TeacherDTO(teaching.getTeacher()),new TeachingTypeDTO(teaching.getTeachingType()),new CourseInstanceDTO(teaching.getCourseInstance())  );
    }

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}

	public TeachingTypeDTO getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingTypeDTO teachingType) {
		this.teachingType = teachingType;
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
