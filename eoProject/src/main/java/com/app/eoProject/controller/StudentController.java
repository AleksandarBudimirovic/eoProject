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

import com.app.eoProject.dto.DocumentDTO;
import com.app.eoProject.dto.ExamInstanceDTO;
import com.app.eoProject.dto.PaymentDTO;
import com.app.eoProject.dto.StudentDTO;
import com.app.eoProject.model.Document;
import com.app.eoProject.model.ExamInstance;
import com.app.eoProject.model.Payment;
import com.app.eoProject.model.Student;
import com.app.eoProject.service.DocumentServiceInterface;
import com.app.eoProject.service.ExamInstanceServiceInterface;
import com.app.eoProject.service.ExamSpecificationServiceInterface;
import com.app.eoProject.service.PaymentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;
import com.app.eoProject.service.UserServiceInterface;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {

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

	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> getStudenti(){
		
		List<Student> studenti = studentService.findAll();		
		
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		
		for(Student a: studenti) {
			
			StudentDTO objDTO = new StudentDTO(a);
			
			studentsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<StudentDTO>>(studentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id) {
		
		Student student = studentService.findOne(id);
		
		if(student == null){
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
		Student student = new Student();
		
		student.setFirstName(studentDTO.getFirstName());
		student.setFirstName(studentDTO.getLastName());
		student.setFirstName(studentDTO.getCardNumber());
		student.setExamSpecification(examSpecService.findOne(studentDTO.getExamSpecification().getId()));
		student.setUser(userService.findOne(studentDTO.getUser().getId()));

		Set<ExamInstance> examInstances = new HashSet<ExamInstance>();
		for(ExamInstanceDTO eiDTO : studentDTO.getExamInstances()) {
			for(ExamInstance ei : examInstService.findAll()) {
				if(eiDTO.getId() == ei.getId()) {
					examInstances.add(ei);
				}
			}
			
			
		}
		student.setExamInstance(examInstances);
		
		Set<Payment> payments = new HashSet<Payment>();
		for(PaymentDTO payDTO : studentDTO.getPayments()) {
			for(Payment pay : paymentService.findAll()) {
				if(payDTO.getId() == pay.getId()) {
					payments.add(pay);
				}
			}
		}
		student.setPayments(payments);
		
		Set<Document> documents = new HashSet<Document>();
		for(DocumentDTO docDTO : studentDTO.getDocuments()) {
			for(Document doc : docService.findAll()) {
				if(docDTO.getId() == doc.getId()) {
					documents.add(doc);
				}
			}
		}
		student.setDocuments(documents);
		

			
		student = studentService.save(student);
		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<StudentDTO> editStudent(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id) {
		
		Student student = studentService.findOne(id); 
		
		if (student == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		student.setFirstName(studentDTO.getFirstName());
		student.setFirstName(studentDTO.getLastName());
		student.setFirstName(studentDTO.getCardNumber());
		student.setExamSpecification(examSpecService.findOne(studentDTO.getExamSpecification().getId()));
		student.setUser(userService.findOne(studentDTO.getUser().getId()));
		Set<ExamInstance> examInstances = new HashSet<ExamInstance>();
		for(ExamInstanceDTO eiDTO : studentDTO.getExamInstances()) {
			for(ExamInstance ei : examInstService.findAll()) {
				if(eiDTO.getId() == ei.getId()) {
					examInstances.add(ei);
				}
			}
			
			
		}
		student.setExamInstance(examInstances);
		
		Set<Payment> payments = new HashSet<Payment>();
		for(PaymentDTO payDTO : studentDTO.getPayments()) {
			for(Payment pay : paymentService.findAll()) {
				if(payDTO.getId() == pay.getId()) {
					payments.add(pay);
				}
			}
		}
		student.setPayments(payments);
		
		Set<Document> documents = new HashSet<Document>();
		for(DocumentDTO docDTO : studentDTO.getDocuments()) {
			for(Document doc : docService.findAll()) {
				if(docDTO.getId() == doc.getId()) {
					documents.add(doc);
				}
			}
		}
		student.setDocuments(documents);
		
		student = studentService.save(student);
		
		return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
		Student student = studentService.findOne(id);
		if (student != null){
			System.out.println("student nije null");
			
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
