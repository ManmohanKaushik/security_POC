package com.bikkadit.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.constants.AppConstants;
import com.bikkadit.dto.StudentDto;
import com.bikkadit.helper.ApiResponse;
import com.bikkadit.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping("/students")
	public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto) {
		logger.info("Start the request for save the student data");
		StudentDto saveStudent = this.studentService.saveStudent(studentDto);
		logger.info("Complete the request for save the student data");
		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);

	}

	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> getAllStudent() {
		logger.info("Start the request for get All the student data");
		List<StudentDto> allStudent = this.studentService.getAllStudent();
		logger.info("Completed the request for get All the student data");
		return new ResponseEntity<List<StudentDto>>(allStudent, HttpStatus.OK);

	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<StudentDto> getSingleStudent(@PathVariable Long studentId) {
		logger.info("Start the request for get single the student data with Id:{}", studentId);
		StudentDto student = this.studentService.getSingleStudent(studentId);
		logger.info("Complate the request for get single the student data with Id:{}", studentId);
		return new ResponseEntity<StudentDto>(student, HttpStatus.OK);

	}

	@PutMapping("/students/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto,
			@PathVariable Long studentId) {
		logger.info("Start the request for update the student data with Id:{}", studentId);
		StudentDto updateStudent = this.studentService.updateStudent(studentDto, studentId);
		logger.info("Start the request for update the student data with Id:{}", studentId);
		return new ResponseEntity<StudentDto>(updateStudent, HttpStatus.CREATED);

	}

	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Long studentId) {
		logger.info("Start the request for delete the student data with Id:{}", studentId);
		this.studentService.deleteStudent(studentId);
		logger.info("Complate the request for delete the student data with Id:{}", studentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.NOT_FOUND, true), HttpStatus.OK);

	}
}
