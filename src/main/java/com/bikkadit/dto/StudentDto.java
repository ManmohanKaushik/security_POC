package com.bikkadit.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
   
	@NotEmpty
	@Size(min = 2, max=25, message = "Name must be 2 digit latters.....!!" )
	private String studentName;
    

	@NotEmpty
	@Size(min = 2, max=100, message = "Address must be proeper in size .....!!" )
	private String studentAddress;
     
	@NotEmpty
	private String rollNumber;
    
	@NotEmpty
	@Size(min = 12, max=12, message = "AdhaarCard must be 12 digit latters.....!!" )
	private String studentAdhaarCard;

	@NotEmpty
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String studentPancard;   //ABDCE1234L
   
	@Email
	private String email;
	
	private String password;

}
