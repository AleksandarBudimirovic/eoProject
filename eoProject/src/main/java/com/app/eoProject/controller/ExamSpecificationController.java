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


import com.app.eoProject.dto.ExamSpecificationDTO;
import com.app.eoProject.model.ExamSpecification;
import com.app.eoProject.service.CourseInstanceServiceInterface;
import com.app.eoProject.service.CourseSpecificationServiceInterface;
import com.app.eoProject.service.DocumentServiceInterface;
import com.app.eoProject.service.ExamInstanceServiceInterface;
import com.app.eoProject.service.ExamSpecificationServiceInterface;
import com.app.eoProject.service.PaymentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;
import com.app.eoProject.service.TeacherServiceInterface;
import com.app.eoProject.service.UserServiceInterface;

@RestController
@RequestMapping(value = "api/exam_specification_controller")
public class ExamSpecificationController {

	@Autowired
	private StudentServiceInterface studentService;
	@Autowired
	private ExamSpecificationServiceInterface examSpecService;
	@Autowired
	private ExamInstanceServiceInterface examInstanceService;
	@Autowired
	private CourseSpecificationServiceInterface courseSpecService;
	@Autowired
	private CourseInstanceServiceInterface courseInstanceService;
	
	@GetMapping
	public ResponseEntity<List<ExamSpecificationDTO>> getExamSpecification(){
		
		List<ExamSpecification> examSpecifications = examSpecService.findAll();		
		
		List<ExamSpecificationDTO> examSpecificationsDTO = new ArrayList<ExamSpecificationDTO>();
		
		for(ExamSpecification a: examSpecifications) {
			
			ExamSpecificationDTO objDTO = new ExamSpecificationDTO(a);
			
			examSpecificationsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<ExamSpecificationDTO>>(examSpecificationsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamSpecificationDTO> getExamSpecification(@PathVariable("id") Long id) {
		
		ExamSpecification examSpecification = examSpecService.findOne(id);
		
		if(examSpecification == null){
			return new ResponseEntity<ExamSpecificationDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExamSpecificationDTO>(new ExamSpecificationDTO(examSpecification), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<ExamSpecificationDTO> addExamSpecification(@RequestBody ExamSpecificationDTO examSpecificationDTO) {
		ExamSpecification examSpecification = new ExamSpecification();
		
		examSpecification.setExamScoreMax(examSpecificationDTO.getExamScoreMax());
		examSpecification.setDate(examSpecificationDTO.getDate());
		examSpecification.setExamInstance(examInstanceService.findOne(examSpecificationDTO.getExamInstance().getId()));
		examSpecification.setStudent(studentService.findOne(examSpecificationDTO.getStudent().getId()));
		

		examSpecification = examSpecService.save(examSpecification);
		return new ResponseEntity<ExamSpecificationDTO>(new ExamSpecificationDTO(examSpecification), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<ExamSpecificationDTO> editExamSpecification(@RequestBody ExamSpecificationDTO examSpecificationDTO, @PathVariable("id") Long id) {
		
		ExamSpecification examSpecification = examSpecService.findOne(id); 
		
		if (examSpecification == null) {
			return new ResponseEntity<ExamSpecificationDTO>(HttpStatus.BAD_REQUEST);
		}
		
		examSpecification.setExamScoreMax(examSpecificationDTO.getExamScoreMax());
		examSpecification.setDate(examSpecificationDTO.getDate());
		examSpecification.setExamInstance(examInstanceService.findOne(examSpecificationDTO.getExamInstance().getId()));
		examSpecification.setStudent(studentService.findOne(examSpecificationDTO.getStudent().getId()));
		

		examSpecification = examSpecService.save(examSpecification);
		

		
		return new ResponseEntity<ExamSpecificationDTO>(new ExamSpecificationDTO(examSpecification), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteExamSpecification(@PathVariable("id") Long id) {
		ExamSpecification examSpecification = examSpecService.findOne(id); 
		if (examSpecification != null){
			System.out.println("ExamSpecification nije null");
			
			System.out.println("Id je: " + id);
			
			examSpecService.remove(id);
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
