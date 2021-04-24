package com.app.eoProject.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.app.eoProject.dto.TeachingDTO;
import com.app.eoProject.dto.TeachingTypeDTO;
import com.app.eoProject.model.Teaching;
import com.app.eoProject.model.TeachingType;
import com.app.eoProject.service.TeachingServiceInterface;
import com.app.eoProject.service.TeachingTypeServiceInterface;

@RestController
@RequestMapping(value = "api/teaching_type")
public class TeachingTypeController {
	
	@Autowired
	private TeachingTypeServiceInterface teachingTypeService;
	@Autowired
	private TeachingServiceInterface teachingService;
	

	
	@GetMapping
	public ResponseEntity<List<TeachingTypeDTO>> getTeachingType(){
		
		List<TeachingType> teachingType = teachingTypeService.findAll();		
		
		List<TeachingTypeDTO> teachingTypeDTO = new ArrayList<TeachingTypeDTO>();
		
		for(TeachingType tt: teachingType) {
			
			TeachingTypeDTO objDTO = new TeachingTypeDTO(tt);
			
			teachingTypeDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<TeachingTypeDTO>>(teachingTypeDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeachingTypeDTO> getTeachingType(@PathVariable("id") Long id) {
		
		TeachingType teachingType = teachingTypeService.findOne(id);
		
		if(teachingType == null){
			return new ResponseEntity<TeachingTypeDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TeachingTypeDTO>(new TeachingTypeDTO(teachingType), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<TeachingTypeDTO> addTeachingType(@RequestBody TeachingTypeDTO teachingTypeDTO) {
		TeachingType teachingType = new TeachingType();
		
		teachingType.setName(teachingTypeDTO.getName());
		teachingType.setCode(teachingTypeDTO.getCode());
		teachingType.setTeachingType(teachingTypeDTO.getTeachingType());
		
		Set<Teaching> teaching = new HashSet<Teaching>();
		for(TeachingDTO tiDTO : teachingTypeDTO.getTeachings()) {
			teaching.add(teachingService.findOne(tiDTO.getId()));
//			for(Teaching ei : teachingService.findAll()) {
//				if(tiDTO.getId() == ei.getId()) {
//					teaching.add(ei);
//				}
//			}
			
			
		}
		teachingType.setTeaching(teaching);
		
			
		teachingType = teachingTypeService.save(teachingType);
		return new ResponseEntity<TeachingTypeDTO>(new TeachingTypeDTO(teachingType), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<TeachingTypeDTO> editTeachingType(@RequestBody TeachingTypeDTO teachingTypeDTO, @PathVariable("id") Long id) {
		
		TeachingType teachingType = teachingTypeService.findOne(id); 
		
		if (teachingType == null) {
			return new ResponseEntity<TeachingTypeDTO>(HttpStatus.BAD_REQUEST);
		}
		
		teachingType.setName(teachingTypeDTO.getName());
		teachingType.setCode(teachingTypeDTO.getCode());
		teachingType.setTeachingType(teachingTypeDTO.getTeachingType());
		
		Set<Teaching> teaching = new HashSet<Teaching>();
		for(TeachingDTO tiDTO : teachingTypeDTO.getTeachings()) {
			teaching.add(teachingService.findOne(tiDTO.getId()));
//			for(Teaching ei : teachingService.findAll()) {
//				if(tiDTO.getId() == ei.getId()) {
//					teaching.add(ei);
//				}
//			}
			
			
		}
		teachingType.setTeaching(teaching);
		
			
		teachingType = teachingTypeService.save(teachingType);
		return new ResponseEntity<TeachingTypeDTO>(new TeachingTypeDTO(teachingType), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTeachingType(@PathVariable("id") Long id) {
		TeachingType teachingType = teachingTypeService.findOne(id);
		if (teachingType != null){
			System.out.println("teachingType nije null");
			
			System.out.println("Id je: " + id);
			
			teachingTypeService.remove(id);
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