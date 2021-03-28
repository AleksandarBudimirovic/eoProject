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

import com.app.eoProject.dto.TeachingDTO;
import com.app.eoProject.model.Teaching;
import com.app.eoProject.service.CourseInstanceServiceInterface;
import com.app.eoProject.service.TeacherServiceInterface;
import com.app.eoProject.service.TeachingServiceInterface;
import com.app.eoProject.service.TeachingTypeServiceInterface;

@RestController
@RequestMapping(value = "api/teaching")
public class TeachingController {
	
	@Autowired
	private TeachingServiceInterface teachingService;
	@Autowired
	private TeacherServiceInterface teacherService;
	@Autowired
	private TeachingTypeServiceInterface teachingTypeService;
	@Autowired
	private CourseInstanceServiceInterface courseInstanceService;
	
	
	@GetMapping
	public ResponseEntity<List<TeachingDTO>> getTeaching(){
		
		List<Teaching> teaching = teachingService.findAll();		
		
		List<TeachingDTO> teachingDTO = new ArrayList<TeachingDTO>();
		
		for(Teaching a: teaching) {
			
			TeachingDTO objDTO = new TeachingDTO(a);
			
			teachingDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<TeachingDTO>>(teachingDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeachingDTO> getTeaching(@PathVariable("id") Long id) {
		
		Teaching teaching = teachingService.findOne(id);
		
		if(teaching == null){
			return new ResponseEntity<TeachingDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TeachingDTO>(new TeachingDTO(teaching), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<TeachingDTO> addTeaching(@RequestBody TeachingDTO teachingDTO) {
		Teaching teaching = new Teaching();
		
		
		teaching.setTeacher(teacherService.findOne(teachingDTO.getTeacher().getId()));
		teaching.setTeachingType(teachingTypeService.findOne(teachingDTO.getTeachingType().getId()));
		teaching.setCourseInstance(courseInstanceService.findOne(teachingDTO.getCourseInstance().getId()));

		
		teaching = teachingService.save(teaching);
		return new ResponseEntity<TeachingDTO>(new TeachingDTO(teaching), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<TeachingDTO> editTeaching(@RequestBody TeachingDTO teachingDTO, @PathVariable("id") Long id) {
		
		Teaching teaching = teachingService.findOne(id); 
		
		if (teaching == null) {
			return new ResponseEntity<TeachingDTO>(HttpStatus.BAD_REQUEST);
		}
		
		teaching.setTeacher(teacherService.findOne(teachingDTO.getTeacher().getId()));
		teaching.setTeachingType(teachingTypeService.findOne(teachingDTO.getTeachingType().getId()));
		teaching.setCourseInstance(courseInstanceService.findOne(teachingDTO.getCourseInstance().getId()));

		
		teaching = teachingService.save(teaching);
		return new ResponseEntity<TeachingDTO>(new TeachingDTO(teaching), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTeaching(@PathVariable("id") Long id) {
		Teaching teaching = teachingService.findOne(id);
		if (teaching != null){
			System.out.println("teaching nije null");
			
			System.out.println("Id je: " + id);
			
			teachingService.remove(id);
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
