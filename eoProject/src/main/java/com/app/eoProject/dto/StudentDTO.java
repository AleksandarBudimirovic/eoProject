package com.app.eoProject.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.app.eoProject.model.Student;

public class StudentDTO implements Serializable{
	
	private Long id;
	private String firstName;
	private String lastName;
	private String cardNumber;
	private ArrayList<DocumentDTO> documents;
	private ArrayList<PaymentDTO> payments;
	private ArrayList<ExamInstanceDTO> examInstances;
	private ExamSpecificationDTO examSpecification;
	private UserDTO user;
	
	public StudentDTO(Long id, String firstName, String lastName, String cardNumber, ArrayList<DocumentDTO> documents,
			ArrayList<PaymentDTO> payments, ArrayList<ExamInstanceDTO> examInstances,
			ExamSpecificationDTO examSpecification, UserDTO user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.documents = documents;
		this.payments = payments;
		this.examInstances = examInstances;
		this.examSpecification = examSpecification;
		this.user = user;
	}

	public StudentDTO() {
		super();
	}

	public StudentDTO(Student student) {
		this(student.getId(), student.getFirstName(), student.getLastName(), student.getCardNumber(), new ArrayList<DocumentDTO>(), new ArrayList<PaymentDTO>(), new ArrayList<ExamInstanceDTO>(),
				new ExamSpecificationDTO(student.getExamSpecification()), new UserDTO(student.getUser());
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public ArrayList<DocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<DocumentDTO> documents) {
		this.documents = documents;
	}

	public ArrayList<PaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<PaymentDTO> payments) {
		this.payments = payments;
	}

	public ArrayList<ExamInstanceDTO> getExamInstances() {
		return examInstances;
	}

	public void setExamInstances(ArrayList<ExamInstanceDTO> examInstances) {
		this.examInstances = examInstances;
	}

	public ExamSpecificationDTO getExamSpecification() {
		return examSpecification;
	}

	public void setExamSpecification(ExamSpecificationDTO examSpecification) {
		this.examSpecification = examSpecification;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
	
}
