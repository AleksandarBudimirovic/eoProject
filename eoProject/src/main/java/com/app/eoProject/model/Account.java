package com.app.eoProject.model;

import java.sql.Date;
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
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "amount", unique = false, nullable = false)
	private int amount;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;
	
/*	//VIDETI DA LI JE OVO DOBRO I DA LI NAM TREBA TA VEZA
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Payment> payment = new HashSet<Payment>();
	
	//VIDETI DA LI JE OVO DOBRO I DA LI NAM TREBA TA VEZA
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Student> student = new HashSet<Student>();
	
	//ili ovo
	@ManyToOne
	@JoinColumn(name="student", referencedColumnName="student_id", nullable=true)
	private Student student;*/

	public Account() {
		super();
	}

	public Account(Long id, String name, int amount, Date date/*, Set<Payment> payment, Set<Student> student*/) {
		super();
		this.id = id;
		this.name= name;
		this.amount = amount;
		this.date = date;
		/*this.payment = payment;
		this.student = student;*/
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	/*public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}*/
	
	
	

}
