package com.app.eoProject.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.eoProject.dto.TeachingDTO;
import com.app.eoProject.dto.UserDTO;
import com.app.eoProject.model.Teacher;

public class TeacherDTO implements Serializable {
	
	private Long id;
	private String firstName;
	private String lastName;
	private ArrayList<TeachingDTO> teaching;
	private UserDTO user;
	
	public TeacherDTO(Long id, String firstName, String lastName, ArrayList<TeachingDTO> teaching, UserDTO user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teaching = teaching;
		this.user = user;
	}

	public TeacherDTO() {
		super();
	}

	public TeacherDTO(Teacher teacher) {
        this(teacher.getId(),teacher.getFirstName() ,teacher.getLastName(), new ArrayList<TeachingDTO>(), new UserDTO(teacher.getUser()) );
    }
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<TeachingDTO> getTeaching() {
		return teaching;
	}

	public void setTeaching(ArrayList<TeachingDTO> teaching) {
		this.teaching = teaching;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}
	
	

	
	
}
