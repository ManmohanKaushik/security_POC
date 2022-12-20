package com.bikkadit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.dto.StudentDto;
import com.bikkadit.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){	
		StudentDto saveStudent = this.studentService.saveStudent(studentDto);	
		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> getAllStudent(){
		List<StudentDto> allStudent = this.studentService.getAllStudent();
		return new ResponseEntity<List<StudentDto>>(allStudent, HttpStatus.OK);
		
	}
	
	
	

	

}
