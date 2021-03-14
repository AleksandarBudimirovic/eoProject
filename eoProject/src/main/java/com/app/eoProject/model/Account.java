package com.app.eoProject.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "amount", unique = false, nullable = false)
	private int amount;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;

	public Account() {
		super();
	}

	public Account(long id, String name, int amount, Date date) {
		super();
		this.id = id;
		this.name= name;
		this.amount = amount;
		this.date = date;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	
	

}
