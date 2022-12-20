package com.bikkadit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
	
	//MODEL - DATABASE
	//DTO - UI/FRONTEND
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@Column(name = "STUDENT_ADDRESS")
	private String studentAddress;
	

	@Column(name = "STUDENT_ROLLNUMBER")
	private String rollNumber;



	
	
	
	

}
