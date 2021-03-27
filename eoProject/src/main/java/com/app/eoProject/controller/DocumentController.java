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

import com.app.eoProject.dto.DocumentDTO;
import com.app.eoProject.model.Document;
import com.app.eoProject.service.DocumentServiceInterface;
import com.app.eoProject.service.StudentServiceInterface;


@RestController
@RequestMapping(value = "api/documents")
public class DocumentController {
	

	@Autowired
	private DocumentServiceInterface docService;
	@Autowired
	private StudentServiceInterface studentService;
	
	
	
	@GetMapping
	public ResponseEntity<List<DocumentDTO>> getDocuments(){
		
		List<Document> documents = docService.findAll();		
		
		List<DocumentDTO> docsDTO = new ArrayList<DocumentDTO>();
		
		for(Document d: documents) {
			
			DocumentDTO objDTO = new DocumentDTO(d);
			
			docsDTO.add(objDTO);
		}
		
		return new ResponseEntity<List<DocumentDTO>>(docsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentDTO> getDocument(@PathVariable("id") Long id) {
		
		Document document = docService.findOne(id);
		
		if(document == null){
			return new ResponseEntity<DocumentDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<DocumentDTO> addDocument(@RequestBody DocumentDTO documentDTO) {
		Document document = new Document();
		
		document.setDocumentType(documentDTO.getDocumentType());
		//document.setStudent(documentDTO.getStudent());
		document.setStudent(studentService.findOne(documentDTO.getStudent().getId()));
		
			
		document = docService.save(document);
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<DocumentDTO> editDocument(@RequestBody DocumentDTO documentDTO, @PathVariable("id") Long id) {
		
		Document document = docService.findOne(id); 
		
		if (document == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		document.setDocumentType(documentDTO.getDocumentType());
		//document.setStudent(documentDTO.getStudent());
		document.setStudent(studentService.findOne(documentDTO.getStudent().getId()));

		
		document = docService.save(document);
		
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteDocument(@PathVariable("id") Long id) {
		Document document = docService.findOne(id);
		if (document != null){
			System.out.println("Document is not null");
			
			System.out.println("Id is: " + id);
			
			docService.remove(id);
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
