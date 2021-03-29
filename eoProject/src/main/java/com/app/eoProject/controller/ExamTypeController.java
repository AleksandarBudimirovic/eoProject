package com.app.eoProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eoProject.dto.ExamTypeDTO;
import com.app.eoProject.model.ExamType;
import com.app.eoProject.service.ExamTypeServiceInterface;

@RestController
@RequestMapping(value = "api/exam_type")
public class ExamTypeController {
	
	@Autowired
	private ExamTypeServiceInterface examTypeService;
	

	
	@GetMapping
	public ResponseEntity<List<ExamTypeDTO>> getExamType(){
		
		List<ExamType> examType = examTypeService.findAll();		
		
		List<ExamTypeDTO> examTypesDTO = new ArrayList<ExamTypeDTO>();
		
		for(ExamType a: examType) {
			
			ExamTypeDTO objDTO = new ExamTypeDTO(a);
			
			examTypesDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<ExamTypeDTO>>(examTypesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamTypeDTO> getExamType(@PathVariable("id") Long id) {
		
		ExamType examType = examTypeService.findOne(id);
		
		if(examType == null){
			return new ResponseEntity<ExamTypeDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExamTypeDTO>(new ExamTypeDTO(examType), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<ExamTypeDTO> addExamType(@RequestBody ExamTypeDTO examTypeDTO) {
		ExamType examType = new ExamType();
		
		examType.setName(examTypeDTO.getName());
		examType.setCode(examTypeDTO.getCode());
		examType.setScore(examTypeDTO.getScore());
		examType.setExamType(examTypeDTO.getExamType());
		
		

			
		examType = examTypeService.save(examType);
		return new ResponseEntity<ExamTypeDTO>(new ExamTypeDTO(examType), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<ExamTypeDTO> editExamType(@RequestBody ExamTypeDTO examTypeDTO, @PathVariable("id") Long id) {
		
		ExamType examType = examTypeService.findOne(id); 
		
		if (examType == null) {
			return new ResponseEntity<ExamTypeDTO>(HttpStatus.BAD_REQUEST);
		}
		
		examType.setName(examTypeDTO.getName());
		examType.setCode(examTypeDTO.getCode());
		examType.setScore(examTypeDTO.getScore());
		examType.setExamType(examTypeDTO.getExamType());
		
		

			
		examType = examTypeService.save(examType);
		return new ResponseEntity<ExamTypeDTO>(new ExamTypeDTO(examType), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteExamType(@PathVariable("id") Long id) {
		ExamType examType = examTypeService.findOne(id);
		if (examType != null){
			System.out.println("ExamType nije null");
			
			System.out.println("Id je: " + id);
			
			examTypeService.remove(id);
			System.out.println("removed");
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			System.out.println("Not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
