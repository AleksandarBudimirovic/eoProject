package com.app.eoProject.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Student student;
	
	@Column(name = "paymentReason", unique = false, nullable = false)
	private String paymentReason;
	
	@Column(name = "receiver", unique = false, nullable = false)
	private String receiver;
	
	@Column(name = "amount", unique = false, nullable = false)
	private double amount;
	
	@Column(name = "recieversAccount", unique = false, nullable = false)
	private String recieversAccount;
	
	@Column(name = "model", unique = false, nullable = false)
	private int model;
	
	@Column(name = "referenceNumber", unique = false, nullable = false)
	private String referenceNumber;
	
	@Column(name = "paymentDate", unique = false, nullable = false)
	private Date paymentDate;

	public Payment() {
		super();
	}

	public Payment(Long id, Student student, String paymentReason, String receiver, double amount,
			String recieversAccount, int model, String referenceNumber, Date paymentDate) {
		super();
		this.id = id;
		this.student = student;
		this.paymentReason = paymentReason;
		this.receiver = receiver;
		this.amount = amount;
		this.recieversAccount = recieversAccount;
		this.model = model;
		this.referenceNumber = referenceNumber;
		this.paymentDate = paymentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPaymentReason() {
		return paymentReason;
	}

	public void setPaymentReason(String paymentReason) {
		this.paymentReason = paymentReason;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRecieversAccount() {
		return recieversAccount;
	}

	public void setRecieversAccount(String recieversAccount) {
		this.recieversAccount = recieversAccount;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	

}
