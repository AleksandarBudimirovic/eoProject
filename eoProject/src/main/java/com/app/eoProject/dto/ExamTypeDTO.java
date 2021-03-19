package com.app.eoProject.dto;

import java.io.Serializable;

import com.app.eoProject.model.ExamType;
import com.app.eoProject.model.ExamTypeEnum;

public class ExamTypeDTO implements Serializable {

	private Long id;
    private String name;
    private String code;
    private Double score;
    private ExamTypeEnum examType;
	
    public ExamTypeDTO(Long id, String name, String code, Double score, ExamTypeEnum examType) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.score = score;
		this.examType = examType;
	}

	public ExamTypeDTO() {
		super();
	}
    
	public ExamTypeDTO(ExamType examType) {
        this(examType.getId(), examType.getName(), examType.getCode(), examType.getScore(),examType.getExamType());
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public ExamTypeEnum getExamType() {
		return examType;
	}

	public void setExamType(ExamTypeEnum examType) {
		this.examType = examType;
	}

	public Long getId() {
		return id;
	}
	
	
    
    
    
	
}
