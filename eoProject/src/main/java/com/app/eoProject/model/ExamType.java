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
@Table(name = "exam_type")
public class ExamType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_type_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	@Column(name = "score", unique = false, nullable = false)
	private Double score;
	
	@Column(name = "exam_type", unique = false, nullable = false)
	private ExamTypeEnum examType;

	public ExamType(Long id, String name, String code, Double score, ExamTypeEnum examType) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.score = score;
		this.examType = examType;
	}

	public ExamType() {
		super();
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

	public ExamTypeEnum getExamType() {
		return examType;
	}

	public void setExamType(ExamTypeEnum examType) {
		this.examType = examType;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	

}
