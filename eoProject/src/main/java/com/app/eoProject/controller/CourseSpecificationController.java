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
import com.app.eoProject.dto.StudentDTO;
import com.app.eoProject.model.CourseSpecification;
import com.app.eoProject.model.Document;
import com.app.eoProject.model.Student;
import com.app.eoProject.service.CourseInstanceService;
import com.app.eoProject.service.CourseInstanceServiceInterface;
import com.app.eoProject.service.CourseSpecificationServiceInterface;
import com.app.eoProject.service.DocumentServiceInterface;
import com.app.eoProject.service.ExamInstanceServiceInterface;
import com.app.eoProject.service.ExamSpecificationServiceInterface;
import com.app.eoProject.service.PaymentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;
import com.app.eoProject.service.UserServiceInterface;

@RestController
@RequestMapping(value = "api/course_specifications")
public class CourseSpecificationController {

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
	
	@GetMapping
	public ResponseEntity<List<CourseSpecificationDTO>> getCourseSpecifications(){
		
		List<CourseSpecification> courseSpecifications = courseSpecService.findAll();		
		
		List<CourseSpecificationDTO> courseSpecificationsDTO = new ArrayList<CourseSpecificationDTO>();
		
		for(CourseSpecification a: courseSpecifications) {
			
			CourseSpecificationDTO objDTO = new CourseSpecificationDTO(a);
			
			courseSpecificationsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<CourseSpecificationDTO>>(courseSpecificationsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseSpecificationDTO> getCourseSpecification(@PathVariable("id") Long id) {
		
		CourseSpecification courseSpecification = courseSpecService.findOne(id);
		
		if(courseSpecification == null){
			return new ResponseEntity<CourseSpecificationDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CourseSpecificationDTO>(new CourseSpecificationDTO(courseSpecification), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<CourseSpecificationDTO> addCourseSpecification(@RequestBody CourseSpecificationDTO courseSpecificationDTO) {
		CourseSpecification courseSpecification = new CourseSpecification();
		
		courseSpecification.setTitle(courseSpecificationDTO.getTitle());
		courseSpecification.setECTS(courseSpecificationDTO.getECTS());
		courseSpecification.setCode(courseSpecificationDTO.getCode());
		courseSpecification.setCourseInstance(courseInstanceService.findOne(courseSpecificationDTO.getId()));
		
		courseSpecification = courseSpecService.save(courseSpecification);
		return new ResponseEntity<CourseSpecificationDTO>(new CourseSpecificationDTO(courseSpecification), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<CourseSpecificationDTO> editCourseSpecification(@RequestBody CourseSpecificationDTO courseSpecificationDTO, @PathVariable("id") Long id) {
		
		CourseSpecification courseSpecification = courseSpecService.findOne(id); 
		
		if (courseSpecification == null) {
			return new ResponseEntity<CourseSpecificationDTO>(HttpStatus.BAD_REQUEST);
		}
		
		courseSpecification.setTitle(courseSpecificationDTO.getTitle());
		courseSpecification.setECTS(courseSpecificationDTO.getECTS());
		courseSpecification.setCode(courseSpecificationDTO.getCode());
		courseSpecification.setCourseInstance(courseInstanceService.findOne(courseSpecificationDTO.getId()));

		
		courseSpecification = courseSpecService.save(courseSpecification);
		
		return new ResponseEntity<CourseSpecificationDTO>(new CourseSpecificationDTO(courseSpecification), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCourseSpecification(@PathVariable("id") Long id) {
		CourseSpecification courseSpecification = courseSpecService.findOne(id);
		if (courseSpecification != null){
			System.out.println("courseSpecification nije null");
			
			System.out.println("Id je: " + id);
			
			courseSpecService.remove(id);
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
