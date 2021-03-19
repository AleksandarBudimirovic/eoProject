package com.app.eoProject.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.app.eoProject.model.TeachingType;
import com.app.eoProject.model.TeachingTypeEnum;

public class TeachingTypeDTO implements Serializable {

	private Long id;
    private String name;
    private String code;
    private TeachingTypeEnum teachingType;
    private ArrayList<TeachingDTO> teachings ;
	
    public TeachingTypeDTO(Long id, String name, String code, TeachingTypeEnum teachingType,
			ArrayList<TeachingDTO> teachings) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.teachingType = teachingType;
		this.teachings = teachings;
	}

	public TeachingTypeDTO() {
		super();
	}
	
	public TeachingTypeDTO(TeachingType teachingType) {
        this(teachingType.getId(), teachingType.getName(), teachingType.getCode(), teachingType.getTeachingType(),new ArrayList<TeachingDTO>());
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

	public ArrayList<TeachingDTO> getTeachings() {
		return teachings;
	}

	public void setTeachings(ArrayList<TeachingDTO> teachings) {
		this.teachings = teachings;
	}

	public Long getId() {
		return id;
	}
    
    
    
    
	
}
