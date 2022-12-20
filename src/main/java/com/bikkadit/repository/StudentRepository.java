package com.bikkadit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
