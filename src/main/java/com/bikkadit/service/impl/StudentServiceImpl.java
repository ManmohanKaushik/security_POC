package com.bikkadit.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.dto.StudentDto;
import com.bikkadit.exception.ResourceNotFoundException;
import com.bikkadit.model.Student;
import com.bikkadit.repository.StudentRepository;
import com.bikkadit.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto saveStudent(StudentDto studentDto) { // Convert StudentDto into Student
		Student student = this.modelMapper.map(studentDto, Student.class);
		Student saveStudent = this.studentRepository.save(student);
		return this.modelMapper.map(saveStudent, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> list = this.studentRepository.findAll();
		List<StudentDto> studentDtos = list.stream().map((demo) -> this.modelMapper.map(demo, StudentDto.class))
				.collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDto getSingleStudent(Long studentId) {

		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found on server!!"));

		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Long studentId) {
		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found on server!!"));
		student.setRollNumber(studentDto.getRollNumber());
		student.setStudentAddress(studentDto.getStudentAddress());
		student.setStudentName(studentDto.getStudentName());

		Student updatedStudent = this.studentRepository.save(student);

		return this.modelMapper.map(updatedStudent, StudentDto.class);
	}

	@Override
	public void deleteStudent(Long studentId) {
		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found on server!!"));
		this.studentRepository.delete(student);

	}

}
