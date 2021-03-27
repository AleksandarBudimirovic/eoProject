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

import com.app.eoProject.dto.ExamInstanceDTO;
import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.service.ExamInstanceServiceInterface;
import com.app.eoProject.service.ExamSpecificationServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;
import com.app.eoProject.service.TeacherServiceInterface;

@RestController
@RequestMapping(value = "api/exam_instance")
public class ExamInstanceController {
	
	@Autowired
	private ExamInstanceServiceInterface examInstService;
	@Autowired
	private StudentServiceInterface studentService;
	@Autowired
	private ExamSpecificationServiceInterface examSpecService;
	@Autowired
	private TeacherServiceInterface teacherService;
	

	
	@GetMapping
	public ResponseEntity<List<ExamInstanceDTO>> getStudenti(){
		
		List<ExamInstance> examIns = examInstService.findAll();		
		
		List<ExamInstanceDTO> examInsDTO = new ArrayList<ExamInstanceDTO>();
		
		for(ExamInstance a: examIns) {
			
			ExamInstanceDTO objDTO = new ExamInstanceDTO(a);
			
			examInsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<ExamInstanceDTO>>(examInsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamInstanceDTO> getExamInstance(@PathVariable("id") Long id) {
		
		ExamInstance examInstance = examInstService.findOne(id);
		
		if(examInstance == null){
			return new ResponseEntity<ExamInstanceDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExamInstanceDTO>(new ExamInstanceDTO(examInstance), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<ExamInstanceDTO> addExamInstance(@RequestBody ExamInstanceDTO examInstanceDTO) {
		ExamInstance examInstance = new ExamInstance();
		
		examInstance.setStartDate(examInstanceDTO.getStartDate());
		examInstance.setEndDate(examInstanceDTO.getEndDate());
		examInstance.setStudent(studentService.findOne(examInstanceDTO.getStudent().getId()));
		examInstance.setPointsScored(examInstanceDTO.getPointsScored());
		examInstance.setTeacher(teacherService.findOne(examInstanceDTO.getTeacher().getId()));
		examInstance.setExamSpecification(examSpecService.findOne(examInstanceDTO.getExamSpecification().getId()));

	
		examInstance = examInstService.save(examInstance);
		return new ResponseEntity<ExamInstanceDTO>(new ExamInstanceDTO(examInstance), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<ExamInstanceDTO> editExamInstance(@RequestBody ExamInstanceDTO examInstanceDTO, @PathVariable("id") Long id) {
		
		ExamInstance examInstance = examInstService.findOne(id); 
		
		if (examInstance == null) {
			return new ResponseEntity<ExamInstanceDTO>(HttpStatus.BAD_REQUEST);
		}
		
		examInstance.setStartDate(examInstanceDTO.getStartDate());
		examInstance.setEndDate(examInstanceDTO.getEndDate());
		examInstance.setStudent(studentService.findOne(examInstanceDTO.getStudent().getId()));
		examInstance.setPointsScored(examInstanceDTO.getPointsScored());
		examInstance.setTeacher(teacherService.findOne(examInstanceDTO.getTeacher().getId()));
		examInstance.setExamSpecification(examSpecService.findOne(examInstanceDTO.getExamSpecification().getId()));
		
		examInstance = examInstService.save(examInstance);
		
		return new ResponseEntity<ExamInstanceDTO>(new ExamInstanceDTO(examInstance), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteExamInstance(@PathVariable("id") Long id) {
		ExamInstance examInstance = examInstService.findOne(id);
		if (examInstance != null){
			System.out.println("Exam Instance is not null");
			
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
