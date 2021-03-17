package com.app.eoProject.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.app.eoProject.model.Payment;
import com.app.eoProject.model.Student;

public class PaymentDTO implements Serializable {
	
	private Long id;
	private StudentDTO student;
	private String paymentReason;
	private String receiver;
	private double amount;
	private String recieversAccount;
	private int model;
	private String referenceNumber;
	private Date paymentDate;
	
	
	public PaymentDTO(Long id, StudentDTO student, String paymentReason, String receiver, double amount,
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
	
	public PaymentDTO() {
		super();
	}
	
	public PaymentDTO (Payment payment) {
		this(payment.getId(), new StudentDTO(payment.getStudent()), payment.getPaymentReason(),
				payment.getReceiver(), payment.getAmount(), payment.getRecieversAccount(),
				payment.getModel(), payment.getReferenceNumber(), payment.getPaymentDate());
	}
	
	
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
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
	public Long getId() {
		return id;
	}
	
	

}
