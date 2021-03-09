package com.app.eoProject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "teacher")
public class Teacher {
	
	
	//@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	//private Set<ExamInstance> examIn = new HashSet<ExamInstance>();


}
