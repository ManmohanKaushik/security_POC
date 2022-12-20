package com.bikkadit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private Long studentId;

	private String studentName;

	private String studentAddress;

	private String rollNumber;

}
