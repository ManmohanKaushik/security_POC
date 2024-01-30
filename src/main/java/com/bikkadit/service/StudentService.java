package com.bikkadit.service;

import java.util.List;

import com.bikkadit.dto.StudentDto;

public interface StudentService {

	StudentDto saveStudent(StudentDto studentDto);

	List<StudentDto> getAllStudent();

	StudentDto getSingleStudent(Long studentId);

	StudentDto updateStudent(StudentDto studentDto, Long studentId);

	void deleteStudent(Long studentId);
	
	StudentDto registerNewUser(StudentDto studentDto);
	
	

}
