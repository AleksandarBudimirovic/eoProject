package com.app.eoProject.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "first_name", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", unique = false, nullable = false)
	private String lastName;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Document> documenti = new HashSet<Document>();
	

	
//	@ManyToOne
//	@JoinColumn(name="student", referencedColumnName="student_id", nullable=true)
	
//	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	private Set<Course> unfinished_courses = new HashSet<Course>();
	
}
