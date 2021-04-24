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

import com.app.eoProject.dto.TeacherDTO;
import com.app.eoProject.dto.TeachingDTO;
import com.app.eoProject.model.Teacher;
import com.app.eoProject.model.Teaching;
import com.app.eoProject.service.TeacherServiceInterface;
import com.app.eoProject.service.TeachingServiceInterface;
import com.app.eoProject.service.UserServiceInterface;

@RestController
@RequestMapping(value = "api/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherServiceInterface teacherService;
	@Autowired
	private TeachingServiceInterface teachingService;
	@Autowired
	private UserServiceInterface userService;

	
	@GetMapping
	public ResponseEntity<List<TeacherDTO>> getTeachers(){
		
		List<Teacher> teachers = teacherService.findAll();		
		
		List<TeacherDTO> teachersDTO = new ArrayList<TeacherDTO>();
		
		for(Teacher a: teachers) {
			
			TeacherDTO objDTO = new TeacherDTO(a);
			
			teachersDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<TeacherDTO>>(teachersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable("id") Long id) {
		
		Teacher teacher = teacherService.findOne(id);
		
		if(teacher == null){
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher();
		
		teacher.setFirstName(teacherDTO.getFirstName());
		teacher.setLastName(teacherDTO.getLastName());
		teacher.setUser(userService.findOne(teacherDTO.getUser().getId()));

		Set<Teaching> teaching = new HashSet<Teaching>();
		for(TeachingDTO eiDTO : teacherDTO.getTeaching()) {
			teaching.add(teachingService.findOne(eiDTO.getId()));
//			for(Teaching ei : teachingService.findAll()) {
//				if(eiDTO.getId() == ei.getId()) {
//					teaching.add(ei);
//				}
//			}
			
			
		}
		teacher.setTeaching(teaching);
		
		
		teacher = teacherService.save(teacher);
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<TeacherDTO> editTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable("id") Long id) {
		
		Teacher teacher = teacherService.findOne(id); 
		
		if (teacher == null) {
			return new ResponseEntity<TeacherDTO>(HttpStatus.BAD_REQUEST);
		}
		
		teacher.setFirstName(teacherDTO.getFirstName());
		teacher.setLastName(teacherDTO.getLastName());
		teacher.setUser(userService.findOne(teacherDTO.getUser().getId()));

		Set<Teaching> teaching = new HashSet<Teaching>();
		for(TeachingDTO eiDTO : teacherDTO.getTeaching()) {
			teaching.add(teachingService.findOne(eiDTO.getId()));
//			for(Teaching ei : teachingService.findAll()) {
//				if(eiDTO.getId() == ei.getId()) {
//					teaching.add(ei);
//				}
//			}
			
			
		}
		teacher.setTeaching(teaching);
		
		
		teacher = teacherService.save(teacher);
		return new ResponseEntity<TeacherDTO>(new TeacherDTO(teacher), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Long id) {
		Teacher teacher = teacherService.findOne(id);
		if (teacher != null){
			System.out.println("teacher nije null");
			
			System.out.println("Id je: " + id);
			
			teacherService.remove(id);
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
