package com.app.eoProject.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.eoProject.model.Account;
import com.app.eoProject.model.Payment;
import com.app.eoProject.model.Student;

public class AccountDTO implements Serializable {

	private Long id;
	
	private String name;
	
	private int amount;
	
	private Date date;
	
	private StudentDTO student;
	
	private ArrayList<PaymentDTO> payments ;

	public AccountDTO(Long id, String name, int amount, Date date, StudentDTO student, ArrayList<PaymentDTO> payments) {
        super();
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.student = student;
        this.payments = payments;
    }


    public AccountDTO() {
        super();
    }

    public AccountDTO(Account account) {
        this(account.getId(), account.getName(), account.getAmount(), account.getDate(), 
            new StudentDTO(account.getStudent()),new ArrayList<PaymentDTO>()); 

    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public StudentDTO getStudent() {
		return student;
	}


	public void setStudent(StudentDTO student) {
		this.student = student;
	}


	public ArrayList<PaymentDTO> getPayments() {
		return payments;
	}


	public void setPayments(ArrayList<PaymentDTO> payments) {
		this.payments = payments;
	}


	public Long getId() {
		return id;
	}
    
   
	
}
