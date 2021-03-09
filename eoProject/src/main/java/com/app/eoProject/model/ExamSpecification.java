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
@Table(name = "examSpecification")
public class ExamSpecification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examSpecification_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "examScoreMax", unique = false, nullable = false)
	private Double examScoreMax;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;

	public ExamSpecification(Long id, Double examScoreMax, Date date) {
		super();
		this.id = id;
		this.examScoreMax = examScoreMax;
		this.date = date;
	}

	public ExamSpecification() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getExamScoreMax() {
		return examScoreMax;
	}

	public void setExamScoreMax(Double examScoreMax) {
		this.examScoreMax = examScoreMax;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

	
}
