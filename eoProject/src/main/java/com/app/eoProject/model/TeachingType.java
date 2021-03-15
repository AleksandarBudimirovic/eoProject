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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teaching_type")
public class TeachingType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teaching_type_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	@Column(name = "teaching_type", unique = false, nullable = false)
	private TeachingTypeEnum teachingType;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "teaching")
	private Set<Teaching> teaching = new HashSet<Teaching>();

	public TeachingType(Long id, String name, String code, TeachingTypeEnum teachingType) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.teachingType = teachingType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public TeachingTypeEnum getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingTypeEnum teachingType) {
		this.teachingType = teachingType;
	}
}