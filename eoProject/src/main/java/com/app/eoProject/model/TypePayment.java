package com.app.eoProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "typePayment")
public class TypePayment {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "name", unique = false, nullable = false)
		private String name;
		
		@Column(name = "code", unique = false, nullable = false)
		private String code;
		
		//@Column(name = "code", unique = false, nullable = false)
		//private Double score;
		

		public TypePayment(String name, String code) {
			super();
			this.name = name;
			this.code = code;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}

		
}
