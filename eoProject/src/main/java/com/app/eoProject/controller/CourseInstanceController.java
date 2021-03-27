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
import com.app.eoProject.dto.CourseSpecificationDTO;
import com.app.eoProject.dto.DocumentDTO;
import com.app.eoProject.dto.ExamInstanceDTO;
import com.app.eoProject.dto.PaymentDTO;
import com.app.eoProject.dto.StudentDTO;
import com.app.eoProject.model.CourseInstance;
import com.app.eoProject.model.CourseSpecification;
import com.app.eoProject.model.Document;
import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.model.Payment;
import com.app.eoProject.model.Student;
import com.app.eoProject.service.CourseInstanceServiceInterface;
import com.app.eoProject.service.CourseSpecificationServiceInterface;
import com.app.eoProject.service.DocumentServiceInterface;
import com.app.eoProject.service.EnrollmentService;
import com.app.eoProject.service.EnrollmentServiceInterface;
import com.app.eoProject.service.ExamInstanceServiceInterface;
import com.app.eoProject.service.ExamSpecificationServiceInterface;
import com.app.eoProject.service.PaymentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;
import com.app.eoProject.service.TeachingServiceInterface;
import com.app.eoProject.service.UserServiceInterface;

@RestController
@RequestMapping(value = "api/course_instance")
public class CourseInstanceController {

	@Autowired
	private StudentServiceInterface studentService;
	@Autowired
	private ExamSpecificationServiceInterface examSpecService;
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private PaymentServiceInterface paymentService;
	@Autowired
	private ExamInstanceServiceInterface examInstService;
	@Autowired
	private DocumentServiceInterface docService;
	@Autowired
	private CourseSpecificationServiceInterface courseSpecService;
	@Autowired
	private CourseInstanceServiceInterface courseInstanceService;
	@Autowired
	private EnrollmentServiceInterface enrollmentService;
	@Autowired
	private TeachingServiceInterface teachingService;
	
	@GetMapping
	public ResponseEntity<List<CourseInstanceDTO>> getCourseInstances(){
		
		List<CourseInstance> courseInstances = courseInstanceService.findAll();		
		
		List<CourseInstanceDTO> courseInstanceDTO = new ArrayList<CourseInstanceDTO>();
		
		for(CourseInstance a: courseInstances) {
			
			CourseInstanceDTO objDTO = new CourseInstanceDTO(a);
			
			courseInstanceDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<CourseInstanceDTO>>(courseInstanceDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseInstanceDTO> getCourseInstance(@PathVariable("id") Long id) {
		
		CourseInstance courseInstance = courseInstanceService.findOne(id);
		
		if(courseInstance == null){
			return new ResponseEntity<CourseInstanceDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CourseInstanceDTO>(new CourseInstanceDTO(courseInstance), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<CourseInstanceDTO> addCourseInstance(@RequestBody CourseInstanceDTO courseInstanceDTO) {
		CourseInstance courseInstance = new CourseInstance();
		
		courseInstance.setStartDate(courseInstanceDTO.getStartDate());
		courseInstance.setEndDate(courseInstanceDTO.getEndDate());
		courseInstance.setExamSpecification(examSpecService.findOne(courseInstanceDTO.getExamSpecification().getId()));
		courseInstance.setEnrollment(enrollmentService.findOne(courseInstanceDTO.getEnrollment().getId()));
		courseInstance.setTeaching(teachingService.findOne(courseInstanceDTO.getTeaching().getId()));
		
		Set<CourseSpecification> courseSpecifications = new HashSet<CourseSpecification>();
		for(CourseSpecificationDTO csDTO : courseInstanceDTO.getCourseSpecification()) {
			for(CourseSpecification cs : courseSpecService.findAll()) {
				if(csDTO.getId() == cs.getId()) {
					courseSpecifications.add(cs);
				}
			}
			
			
		}
		courseInstance.setCourseSpecification(courseSpecifications);
		
		

			
		courseInstance = courseInstanceService.save(courseInstance);
		return new ResponseEntity<CourseInstanceDTO>(new CourseInstanceDTO(courseInstance), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<CourseInstanceDTO> editCourseInstance(@RequestBody CourseInstanceDTO courseInstanceDTO, @PathVariable("id") Long id) {
		
		CourseInstance courseInstance = courseInstanceService.findOne(id); 
		
		if (courseInstance == null) {
			return new ResponseEntity<CourseInstanceDTO>(HttpStatus.BAD_REQUEST);
		}
		
		courseInstance.setStartDate(courseInstanceDTO.getStartDate());
		courseInstance.setEndDate(courseInstanceDTO.getEndDate());
		courseInstance.setExamSpecification(examSpecService.findOne(courseInstanceDTO.getExamSpecification().getId()));
		courseInstance.setEnrollment(enrollmentService.findOne(courseInstanceDTO.getEnrollment().getId()));
		courseInstance.setTeaching(teachingService.findOne(courseInstanceDTO.getTeaching().getId()));
		
		Set<CourseSpecification> courseSpecifications = new HashSet<CourseSpecification>();
		for(CourseSpecificationDTO csDTO : courseInstanceDTO.getCourseSpecification()) {
			for(CourseSpecification cs : courseSpecService.findAll()) {
				if(csDTO.getId() == cs.getId()) {
					courseSpecifications.add(cs);
				}
			}
			
			
		}
		courseInstance.setCourseSpecification(courseSpecifications);
		
		courseInstance = courseInstanceService.save(courseInstance);
		
		return new ResponseEntity<CourseInstanceDTO>(new CourseInstanceDTO(courseInstance), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCourseInstance(@PathVariable("id") Long id) {
		CourseInstance courseInstance = courseInstanceService.findOne(id);
		if (courseInstance != null){
			System.out.println("courseInstance nije null");
			
			System.out.println("Id je: " + id);
			
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
