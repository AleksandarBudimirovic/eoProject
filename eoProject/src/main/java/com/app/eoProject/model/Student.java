package com.app.eoProject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "first_name", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", unique = false, nullable = false)
	private String lastName;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Document> documents = new HashSet<Document>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<ExamInstance> examInstance = new HashSet<ExamInstance>();

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Payment> payments = new HashSet<Payment>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_specification", referencedColumnName = "exam_specification_id")
	private ExamSpecification examSpecification;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment", referencedColumnName = "payment_id")
	private Payment payment;

	public Student(Long id, String firstName, String lastName, Set<Document> documents, Set<ExamInstance> examInstance,
			Set<Payment> payments, ExamSpecification examSpecification, User user, Payment payment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.documents = documents;
		this.examInstance = examInstance;
		this.payments = payments;
		this.examSpecification = examSpecification;
		this.user = user;
		this.payment = payment;
	}

	public Student() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<ExamInstance> getExamInstance() {
		return examInstance;
	}

	public void setExamInstance(Set<ExamInstance> examInstance) {
		this.examInstance = examInstance;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public ExamSpecification getExamSpecification() {
		return examSpecification;
	}

	public void setExamSpecification(ExamSpecification examSpecification) {
		this.examSpecification = examSpecification;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setUser(Payment payment) {
		this.payment = payment;
	}
	
	

	
	
}
