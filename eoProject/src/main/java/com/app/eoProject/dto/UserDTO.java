package com.app.eoProject.dto;

import java.io.Serializable;

import com.app.eoProject.model.Role;
import com.app.eoProject.model.User;
import com.app.eoProject.dto.StudentDTO;
import com.app.eoProject.dto.TeacherDTO;

public class UserDTO implements Serializable {
	
	private Long id;
	private String username;
	private String password;
	private Role role;
	private String email;
	private TeacherDTO teacher;
	private StudentDTO student;
	
	public UserDTO(Long id, String username, String password, Role role, String email, TeacherDTO teacher,
			StudentDTO student) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.teacher = teacher;
		this.student = student;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(User user) {
        this(user.getId(),user.getUsername(), user.getPassword(),user.getRole(), user.getEmail(),
         new TeacherDTO(user.getTeacher()), new StudentDTO(user.getStudent()) );
    }
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

}
