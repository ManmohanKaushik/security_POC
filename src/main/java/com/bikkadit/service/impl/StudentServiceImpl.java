package com.bikkadit.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikkadit.constants.AppConstants;
import com.bikkadit.dto.StudentDto;
import com.bikkadit.exception.ResourceNotFoundException;
import com.bikkadit.model.Role;
import com.bikkadit.model.Student;
import com.bikkadit.repository.RoleRepository;
import com.bikkadit.repository.StudentRepository;
import com.bikkadit.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public StudentDto saveStudent(StudentDto studentDto) { // Convert StudentDto into Student
		logger.info("Start Dao call for the save student details");
		Student student = this.modelMapper.map(studentDto, Student.class);
		Student saveStudent = this.studentRepository.save(student);
		logger.info("Complete Dao call for the save student details");
		return this.modelMapper.map(saveStudent, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		logger.info("Start Dao call for the fetch all the student details");
		List<Student> list = this.studentRepository.findAll();
		List<StudentDto> studentDtos = list.stream().map((demo) -> this.modelMapper.map(demo, StudentDto.class))
				.collect(Collectors.toList());

		logger.info("Complate Dao call for the fetch all the student details");
		return studentDtos;
	}

	@Override
	public StudentDto getSingleStudent(Long studentId) {

		logger.info("Start Dao call for the fetch single student details with Id:{}", studentId);
		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found on server!!"));

		logger.info("Complate Dao call for the fetch single student details with Id:{}", studentId);
		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Long studentId) {

		logger.info("Start Dao call for the update student details with Id:{}", studentId);
		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found on server!!"));
		student.setRollNumber(studentDto.getRollNumber());
		student.setStudentAddress(studentDto.getStudentAddress());
		student.setStudentName(studentDto.getStudentName());
		student.setEmail(studentDto.getEmail());
		student.setStudentPancard(studentDto.getStudentPancard());
		student.setStudentAdhaarCard(studentDto.getStudentAdhaarCard());

		Student updatedStudent = this.studentRepository.save(student);
		logger.info("Complate Dao call for the update student details with Id:{}", studentId);
		return this.modelMapper.map(updatedStudent, StudentDto.class);
	}

	@Override
	public void deleteStudent(Long studentId) {

		logger.info("Start Dao call for the delete  student details with Id:{}", studentId);
		Student student = this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found on server!!"));
		logger.info("Complete Dao call for the delete  student details with Id:{}", studentId);
		this.studentRepository.delete(student);

	}

	@Override
	public StudentDto registerNewUser(StudentDto studentDto) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		student.setPassword(passwordEncoder.encode(studentDto.getPassword()));

		Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();

		student.getRoles().add(role);

		Student savedStudent = this.studentRepository.save(student);

		return this.modelMapper.map(savedStudent, StudentDto.class);
	}

}
