package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	List<Student> findByName(String name);
	List<Student> findByEmail(String email);
}
