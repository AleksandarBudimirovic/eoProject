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

import com.app.eoProject.dto.CourseInstanceDTO;
import com.app.eoProject.dto.EnrollmentDTO;
import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.Enrollment;
import com.app.eoProject.service.CourseInstanceServiceInterface;
import com.app.eoProject.service.EnrollmentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;



@RestController
@RequestMapping(value = "api/enrollments")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentServiceInterface enrollmentService;
	@Autowired
	private StudentServiceInterface studentService;
	@Autowired
	private CourseInstanceServiceInterface courseInstanceService;
	
	
	@GetMapping
	public ResponseEntity<List<EnrollmentDTO>> getEnrollments(){
		
		List<Enrollment> enrollments = enrollmentService.findAll();		
		
		List<EnrollmentDTO> enrollmentsDTO = new ArrayList<EnrollmentDTO>();
		
		for(Enrollment a: enrollments) {
			
			EnrollmentDTO objDTO = new EnrollmentDTO(a);
			
			enrollmentsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<EnrollmentDTO>>(enrollmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EnrollmentDTO> getEnrollment(@PathVariable("id") Long id) {
		
		Enrollment enrollment = enrollmentService.findOne(id);
		
		if(enrollment == null){
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<EnrollmentDTO>(new EnrollmentDTO(enrollment), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<EnrollmentDTO> addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
		Enrollment enrollment = new Enrollment();
		
		enrollment.setStudent(studentService.findOne(enrollmentDTO.getStudent().getId()));;
		enrollment.setStartDate(enrollmentDTO.getStartDate());
		enrollment.setEndDate(enrollmentDTO.getEndDate());
		

		Set<CourseInstance> courseInstances = new HashSet<CourseInstance>();
		for(CourseInstanceDTO ciDTO : enrollmentDTO.getCourseInstanceDTO()) {
			courseInstances.add(courseInstanceService.findOne(ciDTO.getId()));
//			for(CourseInstance ci : courseInstanceService.findAll()) {
//				if(ciDTO.getId() == ci.getId()) {
//					courseInstances.add(ci);
//				}
//			}
		}
		enrollment.setCourseInstance(courseInstances);
		
		
			
		enrollment = enrollmentService.save(enrollment);
		return new ResponseEntity<EnrollmentDTO>(new EnrollmentDTO(enrollment), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<EnrollmentDTO> editEnrollment(@RequestBody EnrollmentDTO enrollmentDTO, @PathVariable("id") Long id) {
		
		Enrollment enrollment = enrollmentService.findOne(id); 
		
		if (enrollment == null) {
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		enrollment.setStudent(studentService.findOne(enrollmentDTO.getStudent().getId()));;
		enrollment.setStartDate(enrollmentDTO.getStartDate());
		enrollment.setEndDate(enrollmentDTO.getEndDate());
		

		Set<CourseInstance> courseInstances = new HashSet<CourseInstance>();
		for(CourseInstanceDTO ciDTO : enrollmentDTO.getCourseInstanceDTO()) {
			courseInstances.add(courseInstanceService.findOne(ciDTO.getId()));
//			for(CourseInstance ci : courseInstanceService.findAll()) {
//				if(ciDTO.getId() == ci.getId()) {
//					courseInstances.add(ci);
//				}
//			}
		}
		enrollment.setCourseInstance(courseInstances);
		
		enrollment = enrollmentService.save(enrollment);
		
		return new ResponseEntity<EnrollmentDTO>(new EnrollmentDTO(enrollment), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable("id") Long id) {
		Enrollment enrollment = enrollmentService.findOne(id);
		if (enrollment != null){
			System.out.println("Enrollment is not null");
			
			System.out.println("Id is: " + id);
			
			studentService.remove(id);
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
